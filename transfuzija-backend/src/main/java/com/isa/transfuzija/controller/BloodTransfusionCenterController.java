package com.isa.transfuzija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.BloodTransfusionCenterDTO;
import com.isa.transfuzija.model.BloodTransfusionCenter;
import com.isa.transfuzija.response.MessageResponse;
import com.isa.transfuzija.service.BloodTransfusionCenterService;

@RestController
@RequestMapping("/api/blood-transfusion-centers")
public class BloodTransfusionCenterController {

	@Autowired
	private BloodTransfusionCenterService bloodTransfusionCenterService;

	@GetMapping
	public ResponseEntity<List<BloodTransfusionCenter>> getCenters() {
		return new ResponseEntity<List<BloodTransfusionCenter>>(bloodTransfusionCenterService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCenter(@PathVariable Long id) {
		return new ResponseEntity<BloodTransfusionCenter>(bloodTransfusionCenterService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addCenter(@RequestBody BloodTransfusionCenterDTO centerDTO) {
		bloodTransfusionCenterService.save(centerDTO);
		return ResponseEntity.ok(new MessageResponse("Blood transfusion center successfully added."));
	}

	@PutMapping
	public void updateCenter(@RequestBody BloodTransfusionCenterDTO centerDTO) {
		bloodTransfusionCenterService.update(centerDTO);
	}

}
