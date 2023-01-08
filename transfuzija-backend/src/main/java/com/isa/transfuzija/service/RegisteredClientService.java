package com.isa.transfuzija.service;

import java.util.List;

import com.isa.transfuzija.dto.QuestionnaireDTO;
import com.isa.transfuzija.dto.RegisteredClientDTO;
import com.isa.transfuzija.model.BloodCenterAppointment;

public interface RegisteredClientService {

	List<RegisteredClientDTO> findAll();

	RegisteredClientDTO findById(Long id);

	void editRegisteredClient(RegisteredClientDTO clientDTO);

	void saveQuestionnaire(Long id, QuestionnaireDTO questionnaireDTO);

	List<BloodCenterAppointment> getAllClientAppointment(Long id);

	List<BloodCenterAppointment> getUpcomingClientAppointment(Long id);

	List<BloodCenterAppointment> getPastClientAppointment(Long id);

}
