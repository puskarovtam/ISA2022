package com.isa.transfuzija.service;

import java.util.List;

import com.isa.transfuzija.dto.RegisteredClientDTO;

public interface RegisteredClientService {

	List<RegisteredClientDTO> findAll();

	RegisteredClientDTO findById(Long id);

}
