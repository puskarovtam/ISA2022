package com.isa.transfuzija.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.QuestionnaireDTO;
import com.isa.transfuzija.model.Questionnaire;
import com.isa.transfuzija.repository.QuestionnaireRepository;
import com.isa.transfuzija.service.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@Override
	public QuestionnaireDTO findById(Long id) {
		Questionnaire questionnaire = questionnaireRepository.findById(id).get();
		QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(questionnaire);
		return questionnaireDTO;
	}

}
