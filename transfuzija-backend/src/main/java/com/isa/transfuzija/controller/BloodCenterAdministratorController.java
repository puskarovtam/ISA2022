package com.isa.transfuzija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<BloodCenterAdministratorDTO> findAllCenterAdmins(@PathVariable Long id) {
		return bloodCenterAdministratorService.findAllByCenter(id);
	}

	@GetMapping("/admin/{id}")
	public BloodCenterAdministratorDTO findByAdminId(@PathVariable Long id) {
		return bloodCenterAdministratorService.findById(id);
	}

}
