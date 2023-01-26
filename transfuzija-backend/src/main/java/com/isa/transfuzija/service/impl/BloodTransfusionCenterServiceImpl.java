package com.isa.transfuzija.service.impl;

import java.util.ArrayList;
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
	public List<BloodTransfusionCenterDTO> findAll() {
		List<BloodTransfusionCenterDTO> centersDTO = new ArrayList<>();
		List<BloodTransfusionCenter> centers = bloodTransfusionCenterRepository.findAll();

		for (BloodTransfusionCenter c : centers) {
			centersDTO.add(new BloodTransfusionCenterDTO(c));
		}
		return centersDTO;
	}

	@Override
	public BloodTransfusionCenterDTO findById(Long id) {
		BloodTransfusionCenter center = bloodTransfusionCenterRepository.findById(id).orElseGet(null);
		BloodTransfusionCenterDTO centerDTO = new BloodTransfusionCenterDTO(center);
		return centerDTO;
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
		BloodTransfusionCenter btc = bloodTransfusionCenterRepository.findById(centerDTO.getId()).get();
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
