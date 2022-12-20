package com.isa.transfuzija.service;

import java.util.List;

import com.isa.transfuzija.dto.BloodCenterAdministratorDTO;

public interface BloodCenterAdministratorService {
	
	List<BloodCenterAdministratorDTO> findAll();
	
	List<BloodCenterAdministratorDTO> findAllByCenter(Long bloodCenterId);
	
	BloodCenterAdministratorDTO findById(Long id);

}
