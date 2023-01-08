package com.isa.transfuzija.service;

import java.util.List;

import org.springframework.dao.PessimisticLockingFailureException;

import com.isa.transfuzija.dto.BloodCenterAppointmentCreateDTO;
import com.isa.transfuzija.dto.BloodCenterAppointmentDTO;
import com.isa.transfuzija.model.BloodCenterAppointment;

public interface BloodCenterAppointmentService {

	List<BloodCenterAppointmentDTO> findAllBloodCenterAppointments(Long bloodCenterId);

	BloodCenterAppointmentCreateDTO findById(Long id);

	BloodCenterAppointment save(BloodCenterAppointmentCreateDTO appointmentDTO);

	BloodCenterAppointmentDTO bookAppointment(Long clientId, Long appointmentId)
			throws PessimisticLockingFailureException;

	BloodCenterAppointmentDTO cancelAppointment(Long clientId, Long appointmentId);

}
