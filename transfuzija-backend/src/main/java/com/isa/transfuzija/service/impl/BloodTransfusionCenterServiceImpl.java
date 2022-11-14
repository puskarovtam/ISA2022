package com.isa.transfuzija.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.BloodTransfusionCenterDTO;
import com.isa.transfuzija.model.BloodTransfusionCenter;
import com.isa.transfuzija.repository.BloodTransfusionCenterRepository;
import com.isa.transfuzija.service.BloodTransfusionCenterService;

@Service
public class BloodTransfusionCenterServiceImpl implements BloodTransfusionCenterService {

	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;

	@Override
	public List<BloodTransfusionCenter> findAll() {
		return bloodTransfusionCenterRepository.findAll();
	}

	@Override
	public BloodTransfusionCenter findById(Long id) {
		return bloodTransfusionCenterRepository.findById(id).orElseGet(null);
	}

	@Override
	public BloodTransfusionCenter save(BloodTransfusionCenterDTO centerDTO) {
		BloodTransfusionCenter btc = new BloodTransfusionCenter();
		btc.setName(centerDTO.getName());
		btc.setAddress(centerDTO.getAddress());
		btc.setCity(centerDTO.getCity());
		btc.setCountry(centerDTO.getCountry());
		btc.setDescription(centerDTO.getDescription());
		btc.setRating(0.0);

		return bloodTransfusionCenterRepository.save(btc);
	}

	@Override
	public void update(BloodTransfusionCenterDTO centerDTO) {
		BloodTransfusionCenter btc = bloodTransfusionCenterRepository.getOne(centerDTO.getId());
		btc.setName(centerDTO.getName());
		btc.setAddress(centerDTO.getAddress());
		btc.setCity(centerDTO.getCity());
		btc.setCountry(centerDTO.getCountry());
		btc.setDescription(centerDTO.getDescription());
		btc.setRating(centerDTO.getRating());

		bloodTransfusionCenterRepository.save(btc);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
