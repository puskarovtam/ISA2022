package com.isa.transfuzija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.QuestionnaireDTO;
import com.isa.transfuzija.service.QuestionnaireService;

@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService questionnaireService;

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('REGISTERED_CLIENT')")
	public QuestionnaireDTO findById(@PathVariable Long id) {
		return questionnaireService.findById(id);
	}

}
