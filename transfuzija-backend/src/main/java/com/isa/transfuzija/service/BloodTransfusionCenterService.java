package com.isa.transfuzija.service;

import java.util.List;

import com.isa.transfuzija.dto.BloodTransfusionCenterDTO;
import com.isa.transfuzija.model.BloodTransfusionCenter;

public interface BloodTransfusionCenterService {

	List<BloodTransfusionCenterDTO> findAll();

	BloodTransfusionCenter findById(Long id);

	BloodTransfusionCenter save(BloodTransfusionCenterDTO centerDTO);

	void update(BloodTransfusionCenterDTO centerDTO);

	void delete(Long id);

}
