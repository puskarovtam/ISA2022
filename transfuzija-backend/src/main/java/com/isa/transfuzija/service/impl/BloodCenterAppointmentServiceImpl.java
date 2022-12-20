package com.isa.transfuzija.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.BloodCenterAppointmentCreateDTO;
import com.isa.transfuzija.dto.BloodCenterAppointmentDTO;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.model.BloodTransfusionCenter;
import com.isa.transfuzija.repository.BloodCenterAdministratorRepository;
import com.isa.transfuzija.repository.BloodCenterAppointmentRepository;
import com.isa.transfuzija.repository.BloodTransfusionCenterRepository;
import com.isa.transfuzija.service.BloodCenterAppointmentService;

@Service
public class BloodCenterAppointmentServiceImpl implements BloodCenterAppointmentService {

	@Autowired
	private BloodCenterAppointmentRepository bloodCenterAppointmentRepository;
	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	@Autowired
	private BloodCenterAdministratorRepository bloodCenterAdministratorRepository;

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

}
