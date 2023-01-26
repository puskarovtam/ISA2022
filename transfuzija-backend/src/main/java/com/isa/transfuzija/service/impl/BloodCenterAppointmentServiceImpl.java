package com.isa.transfuzija.service.impl;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
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
import com.isa.transfuzija.service.DateService;
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
	@Autowired
	private DateService dateService;

	@Override
	public List<BloodCenterAppointmentDTO> findAllBloodCenterAppointments(Long bloodCenterId) {
		Optional<BloodTransfusionCenter> center = bloodTransfusionCenterRepository.findById(bloodCenterId);
		if (!center.isPresent()) {
			throw new NoSuchElementException("Centar za transfuziju nije pronadjen.");
		}

		List<BloodCenterAppointmentDTO> appointmentsDTO = new ArrayList<>();
		List<BloodCenterAppointment> appointments = bloodCenterAppointmentRepository
				.getByCenterAndIsReservedFalseAndIsDeletedFalse(center.get());

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
		appointment.setIsReserved(false);
		appointment.setIsDeleted(false);

		bloodCenterAppointmentRepository.save(appointment);

		return appointment;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public BloodCenterAppointmentDTO bookAppointment(Long clientId, Long appointmentId)
			throws PessimisticLockingFailureException {
		Optional<RegisteredClient> client = registeredClientRepository.findById(clientId);

		BloodCenterAppointment appointment = bloodCenterAppointmentRepository.findOneById(appointmentId);

		if (client == null) {
			throw new ValidationException("Client with given ID does not exist.");
		}

		if (appointment == null) {
			throw new ValidationException("Appointmnet with given ID does not exist.");
		}

		if (!appointment.getIsReserved()) {
			if (client.get().getQuestionnaireCompleted()) {
				appointment.setClient(client.get());
				appointment.setIsCanceled(false);
				appointment.setIsReserved(true);
			}
		}

		BloodCenterAppointment bca = bloodCenterAppointmentRepository.save(appointment);
		client.get().getBloodCenterAppointments().add(bca);
		registeredClientRepository.save(client.get());

		String qrCodeContent = "Naziv centra za transfuziju: " + appointment.getCenter().getName() + " \n\n "
				+ "Datum i vreme zakazanog termina: "
				+ appointment.getAppointmentStart().format(FormatDateTime.DD_MM_YYYY.getFormatter()) + " \n\n "
				+ "Registrovani klijent: " + appointment.getClient().getName() + " "
				+ appointment.getClient().getSurname();

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

		if (client == null) {
			throw new ValidationException("Client with given ID does not exist.");
		}

		if (appointment == null) {
			throw new ValidationException("Appointmnet with given ID does not exist.");
		}

		if (appointment != null) {
			appointment.setIsCanceled(true);
			appointment.setIsReserved(false);
		}

		BloodCenterAppointment bca = bloodCenterAppointmentRepository.save(appointment);

		return new BloodCenterAppointmentDTO(bca);
	}

	@Override
	public Boolean clientHasCancelledAppointment(Long clientId, Long appointmentId) {
		RegisteredClient client = registeredClientRepository.findById(clientId).get();
		BloodCenterAppointment appointment = bloodCenterAppointmentRepository.findById(appointmentId).get();

		for (BloodCenterAppointment app : client.getBloodCenterAppointments()) {
			if (app.equals(appointment)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean clientHasAlreadyAppointmentInThatTime(Long clientId, LocalDateTime timeOfAppointment) {
		RegisteredClient client = registeredClientRepository.findById(clientId).get();

		if (client != null) {
			for (BloodCenterAppointment appointment : client.getBloodCenterAppointments()) {
				if (!appointment.getIsCanceled()) {
					if (dateService.doDatesOverlap(appointment.getAppointmentStart(), timeOfAppointment)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
