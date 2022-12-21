package com.isa.transfuzija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.RegisteredClientDTO;
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
	public RegisteredClientDTO findClientById(@PathVariable Long id) {
		return registeredClientService.findById(id);
	}

}
