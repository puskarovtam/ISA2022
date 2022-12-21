package com.isa.transfuzija.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.RegisteredClientDTO;
import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.repository.RegisteredClientRepository;
import com.isa.transfuzija.service.RegisteredClientService;

@Service
public class RegisteredClientServiceImpl implements RegisteredClientService {

	@Autowired
	private RegisteredClientRepository registeredClientRepository;

	@Override
	public List<RegisteredClientDTO> findAll() {
		List<RegisteredClientDTO> clientsDTO = new ArrayList<>();
		List<RegisteredClient> clients = registeredClientRepository.findAll();

		for (RegisteredClient r : clients) {
			clientsDTO.add(new RegisteredClientDTO(r));
		}
		return clientsDTO;
	}

	@Override
	public RegisteredClientDTO findById(Long id) {
		RegisteredClient client = registeredClientRepository.findById(id).get();
		RegisteredClientDTO clientDTO = new RegisteredClientDTO(client);
		return clientDTO;
	}

}
