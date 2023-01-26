package com.isa.transfuzija.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.BloodCenterAppointmentDTO;
import com.isa.transfuzija.dto.QuestionnaireDTO;
import com.isa.transfuzija.dto.RegisteredClientDTO;
import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.service.RegisteredClientService;

@RestController
@RequestMapping("/api/clients")
public class RegisteredClientController {

	@Autowired
	private RegisteredClientService registeredClientService;

	@GetMapping
	public List<RegisteredClientDTO> findAllClients() {
		return registeredClientService.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public RegisteredClientDTO findClientById(@PathVariable Long id) {
		return registeredClientService.findById(id);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public ResponseEntity<?> editRegisteredClient(@RequestBody RegisteredClientDTO clientDTO) {
		if (clientDTO != null) {
			registeredClientService.editRegisteredClient(clientDTO);
			return new ResponseEntity<>(clientDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/{id}/questionnaire")
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public ResponseEntity<?> saveQuestionnaire(@PathVariable Long id, @RequestBody QuestionnaireDTO questionnaireDTO) {
		registeredClientService.saveQuestionnaire(id, questionnaireDTO);
		return new ResponseEntity<>(questionnaireDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}/upcoming-appointments")
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public ResponseEntity<List<BloodCenterAppointmentDTO>> findUpcomingClientAppointments(@PathVariable Long id) {
		List<BloodCenterAppointment> appointments = registeredClientService.getUpcomingClientAppointment(id);
		List<BloodCenterAppointmentDTO> dtos = new ArrayList<>();
		for (BloodCenterAppointment a : appointments) {
			BloodCenterAppointmentDTO app = new BloodCenterAppointmentDTO(a);
			dtos.add(app);
		}
		return new ResponseEntity<List<BloodCenterAppointmentDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping("/{id}/past-appointments")
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public ResponseEntity<List<BloodCenterAppointmentDTO>> findPastClientAppointments(@PathVariable Long id) {
		List<BloodCenterAppointment> appointments = registeredClientService.getPastClientAppointment(id);
		List<BloodCenterAppointmentDTO> dtos = new ArrayList<>();
		for (BloodCenterAppointment a : appointments) {
			BloodCenterAppointmentDTO app = new BloodCenterAppointmentDTO(a);
			dtos.add(app);
		}
		return new ResponseEntity<List<BloodCenterAppointmentDTO>>(dtos, HttpStatus.OK);
	}

}
