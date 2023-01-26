package com.isa.transfuzija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.BloodCenterAdministratorDTO;
import com.isa.transfuzija.service.BloodCenterAdministratorService;

@RestController
@RequestMapping("/api/center-admins")
public class BloodCenterAdministratorController {

	@Autowired
	private BloodCenterAdministratorService bloodCenterAdministratorService;

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('CENTER_ADMINISTRATOR')")
	public List<BloodCenterAdministratorDTO> findAllCenterAdmins(@PathVariable Long id) {
		return bloodCenterAdministratorService.findAllByCenter(id);
	}

	@GetMapping("/admin/{id}")
	@PreAuthorize("hasAuthority('CENTER_ADMINISTRATOR')")
	public BloodCenterAdministratorDTO findByAdminId(@PathVariable Long id) {
		return bloodCenterAdministratorService.findById(id);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('CENTER_ADMINISTRATOR')")
	public ResponseEntity<?> editCenterAdministrator(@RequestBody BloodCenterAdministratorDTO adminDTO) {
		if (adminDTO != null) {
			bloodCenterAdministratorService.editCenterAdministrator(adminDTO);
			return new ResponseEntity<>(adminDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
