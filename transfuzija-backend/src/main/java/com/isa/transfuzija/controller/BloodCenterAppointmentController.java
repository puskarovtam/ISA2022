package com.isa.transfuzija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.BloodCenterAppointmentCreateDTO;
import com.isa.transfuzija.dto.BloodCenterAppointmentDTO;
import com.isa.transfuzija.service.BloodCenterAppointmentService;

@RestController
@RequestMapping("/api/blood-center-appointments")
public class BloodCenterAppointmentController {

	@Autowired
	private BloodCenterAppointmentService bloodCenterAppointmentService;

	@GetMapping("/center/{id}")
	public ResponseEntity<List<BloodCenterAppointmentDTO>> getAppointmentsByCenterId(@PathVariable Long id) {
		List<BloodCenterAppointmentDTO> appointmentsDTO = bloodCenterAppointmentService
				.findAllBloodCenterAppointments(id);
		return new ResponseEntity<List<BloodCenterAppointmentDTO>>(appointmentsDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createAppointment(
			@RequestBody BloodCenterAppointmentCreateDTO appointmentDTO) {
		bloodCenterAppointmentService.save(appointmentDTO);
		return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
	}
	
	@PutMapping("/book/{clientId}/{appointmentId}")
	public ResponseEntity<?> bookAppointment(@PathVariable Long clientId, @PathVariable Long appointmentId) {
		if (clientId == null || appointmentId == null) {
			return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
		}
		try {
			BloodCenterAppointmentDTO appointmentDTO = bloodCenterAppointmentService.bookAppointment(clientId,
					appointmentId);
			return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
		} catch (PessimisticLockingFailureException e) {
			return new ResponseEntity<>("This appointment has already been taken.", HttpStatus.CONFLICT);
		}

	}

}
