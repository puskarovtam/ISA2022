package com.isa.transfuzija.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.BloodCenterAdministratorDTO;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.repository.BloodCenterAdministratorRepository;
import com.isa.transfuzija.service.BloodCenterAdministratorService;

@Service
public class BloodCenterAdministratorServiceImpl implements BloodCenterAdministratorService {

	@Autowired
	private BloodCenterAdministratorRepository bloodCenterAdministratorRepository;

	@Override
	public List<BloodCenterAdministratorDTO> findAll() {
		List<BloodCenterAdministratorDTO> adminsDTO = new ArrayList<>();
		List<BloodCenterAdministrator> admins = bloodCenterAdministratorRepository.findAll();

		for (BloodCenterAdministrator a : admins) {
			adminsDTO.add(new BloodCenterAdministratorDTO(a));
		}
		return adminsDTO;
	}

	@Override
	public List<BloodCenterAdministratorDTO> findAllByCenter(Long bloodCenterId) {
		List<BloodCenterAdministratorDTO> adminsDTO = new ArrayList<>();
		List<BloodCenterAdministrator> admins = bloodCenterAdministratorRepository
				.findByTransfusionCenterId(bloodCenterId);

		for (BloodCenterAdministrator a : admins) {
			adminsDTO.add(new BloodCenterAdministratorDTO(a));
		}
		return adminsDTO;

	}

	@Override
	public BloodCenterAdministratorDTO findById(Long id) {
		BloodCenterAdministrator admin = bloodCenterAdministratorRepository.findById(id).get();
		BloodCenterAdministratorDTO adminDTO = new BloodCenterAdministratorDTO(admin);
		return adminDTO;
	}

}
