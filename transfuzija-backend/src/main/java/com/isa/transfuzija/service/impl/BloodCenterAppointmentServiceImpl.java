package com.isa.transfuzija.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isa.transfuzija.dto.BloodCenterAppointmentCreateDTO;
import com.isa.transfuzija.dto.BloodCenterAppointmentDTO;
import com.isa.transfuzija.enums.FormatDateTime;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.model.BloodTransfusionCenter;
import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.repository.BloodCenterAdministratorRepository;
import com.isa.transfuzija.repository.BloodCenterAppointmentRepository;
import com.isa.transfuzija.repository.BloodTransfusionCenterRepository;
import com.isa.transfuzija.repository.RegisteredClientRepository;
import com.isa.transfuzija.service.BloodCenterAppointmentService;
import com.isa.transfuzija.service.EmailService;
import com.isa.transfuzija.service.QrCodeService;

@Service
public class BloodCenterAppointmentServiceImpl implements BloodCenterAppointmentService {

	@Autowired
	private BloodCenterAppointmentRepository bloodCenterAppointmentRepository;
	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	@Autowired
	private BloodCenterAdministratorRepository bloodCenterAdministratorRepository;
	@Autowired
	private RegisteredClientRepository registeredClientRepository;
	@Autowired
	private QrCodeService qrCodeService;
	@Autowired
	private EmailService emailService;

	@Override
	public List<BloodCenterAppointmentDTO> findAllBloodCenterAppointments(Long bloodCenterId) {
		Optional<BloodTransfusionCenter> center = bloodTransfusionCenterRepository.findById(bloodCenterId);
		if (!center.isPresent()) {
			throw new NoSuchElementException("Centar za transfuziju nije pronadjen.");
		}

		List<BloodCenterAppointmentDTO> appointmentsDTO = new ArrayList<>();
		List<BloodCenterAppointment> appointments = bloodCenterAppointmentRepository
				.getByCenterAndClientNullAndIsDeletedFalse(center.get());

		for (BloodCenterAppointment a : appointments) {
			appointmentsDTO.add(new BloodCenterAppointmentDTO(a));
		}

		return appointmentsDTO;
	}

	@Override
	public BloodCenterAppointmentCreateDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BloodCenterAppointment save(BloodCenterAppointmentCreateDTO appointmentDTO) {
		Optional<BloodTransfusionCenter> center = bloodTransfusionCenterRepository
				.findById(appointmentDTO.getCenterID());
		Optional<BloodCenterAdministrator> stuff = bloodCenterAdministratorRepository
				.findById(appointmentDTO.getStuffID());

		BloodCenterAppointment appointment = new BloodCenterAppointment();

		appointment.setAppointmentStart(appointmentDTO.getAppointmentStart());
		appointment.setDuration(appointmentDTO.getDuration());
		appointment.setCenter(center.get());
		appointment.setStuff(stuff.get());
		appointment.setIsCompleted(false);
		appointment.setIsCanceled(false);
		appointment.setIsDeleted(false);

		bloodCenterAppointmentRepository.save(appointment);

		return appointment;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public BloodCenterAppointmentDTO bookAppointment(Long clientId, Long appointmentId)
			throws PessimisticLockingFailureException {
		Optional<RegisteredClient> client = registeredClientRepository.findById(clientId);

		if (!client.isPresent()) {
			throw new ValidationException("Client with given id does not exist.");
		}

		BloodCenterAppointment appointment = bloodCenterAppointmentRepository.findOneById(appointmentId);
		if (appointment == null) {
			throw new ValidationException("Appointmnet does not exist.");
		}

		if (appointment.getClient() != null) {
			throw new ValidationException("Appointment is already booked.");
		}

		appointment.setClient(client.get());
		BloodCenterAppointment bca = bloodCenterAppointmentRepository.save(appointment);
		client.get().getBloodCenterAppointments().add(bca);
		registeredClientRepository.save(client.get());
		
		String qrCodeContent = "Naziv centra za transfuziju: " + appointment.getCenter().getName() + " \n\n "
				+ "Datum i vreme zakazanog termina: " + appointment.getAppointmentStart().format(FormatDateTime.DD_MM_YYYY.getFormatter()) + " \n\n "
				+ "Registrovani klijent: " + appointment.getClient().getName() + " " + appointment.getClient().getSurname();
		
		byte[] qrCode = qrCodeService.generateQrCode(qrCodeContent, 500, 500);
		
		try {
			emailService.sendAppointmentEmail(client.get(), qrCode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new BloodCenterAppointmentDTO(bca);
	}

	@Override
	public BloodCenterAppointmentDTO cancelAppointment(Long clientId, Long appointmentId) {
		RegisteredClient client = registeredClientRepository.findById(clientId).get();
		BloodCenterAppointment appointment = bloodCenterAppointmentRepository.findById(appointmentId).get();

		if (appointment.getClient() == null) {
			throw new ValidationException("Appointment has no client set");
		}

		appointment.setClient(null);
		client.getBloodCenterAppointments().remove(appointment);
		registeredClientRepository.save(client);

		BloodCenterAppointment bca = bloodCenterAppointmentRepository.save(appointment);

		return new BloodCenterAppointmentDTO(bca);
	}

}
