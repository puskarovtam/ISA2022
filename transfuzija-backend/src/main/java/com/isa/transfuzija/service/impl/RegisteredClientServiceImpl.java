package com.isa.transfuzija.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.QuestionnaireDTO;
import com.isa.transfuzija.dto.RegisteredClientDTO;
import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.model.Questionnaire;
import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.repository.QuestionnaireRepository;
import com.isa.transfuzija.repository.RegisteredClientRepository;
import com.isa.transfuzija.service.RegisteredClientService;

@Service
public class RegisteredClientServiceImpl implements RegisteredClientService {

	@Autowired
	private RegisteredClientRepository registeredClientRepository;
	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@Override
	public List<RegisteredClientDTO> findAll() {
		List<RegisteredClientDTO> clientsDTO = new ArrayList<>();
		List<RegisteredClient> clients = registeredClientRepository.findAll();

		for (RegisteredClient r : clients) {
			clientsDTO.add(new RegisteredClientDTO(r));
		}
		return clientsDTO;
	}

	@Override
	public RegisteredClientDTO findById(Long id) {
		RegisteredClient client = registeredClientRepository.findById(id).get();
		RegisteredClientDTO clientDTO = new RegisteredClientDTO(client);
		return clientDTO;
	}

	@Override
	public void editRegisteredClient(RegisteredClientDTO clientDTO) {
		RegisteredClient client = registeredClientRepository.findById(clientDTO.getId()).get();

		if (client != null) {
			client.setName(clientDTO.getName());
			client.setSurname(clientDTO.getSurname());
			client.setAddress(clientDTO.getAddress());
			client.setCity(clientDTO.getCity());
			client.setCountry(clientDTO.getCountry());
			client.setPhoneNumber(clientDTO.getPhoneNumber());
			client.setJmbg(clientDTO.getJmbg());
			client.setGender(clientDTO.getGender());
			client.setOccupation(clientDTO.getOccupation());

			registeredClientRepository.save(client);
		} else {
			throw new ValidationException("Client does not exist.");
		}

	}

	@Override
	public void saveQuestionnaire(Long id, QuestionnaireDTO questionnaireDTO) {
		if (id == null) {
			throw new ValidationException("Client not recognized.");
		}

		RegisteredClient client = registeredClientRepository.findById(id).get();
		if (client == null) {
			throw new ValidationException("Client does not exist.");
		}

		Questionnaire questionnaire = new Questionnaire();

		questionnaire.setQuestion1(questionnaireDTO.getQuestion1());
		questionnaire.setQuestion2(questionnaireDTO.getQuestion2());
		questionnaire.setQuestion3(questionnaireDTO.getQuestion3());
		questionnaire.setQuestion4(questionnaireDTO.getQuestion4());
		questionnaire.setQuestion5(questionnaireDTO.getQuestion5());
		questionnaire.setQuestion6(questionnaireDTO.getQuestion6());
		questionnaire.setQuestion7(questionnaireDTO.getQuestion7());
		questionnaire.setQuestion8(questionnaireDTO.getQuestion8());
		questionnaire.setQuestion9(questionnaireDTO.getQuestion9());
		questionnaire.setQuestion10(questionnaireDTO.getQuestion10());
		questionnaire.setQuestion11(questionnaireDTO.getQuestion11());
		questionnaire.setQuestion12(questionnaireDTO.getQuestion12());
		questionnaire.setQuestion13(questionnaireDTO.getQuestion13());
		questionnaire.setQuestion14(questionnaireDTO.getQuestion14());

		questionnaireRepository.save(questionnaire);

		client.setQuestionnaire(questionnaire);
		client.setQuestionnaireCompleted(true);

		registeredClientRepository.save(client);

	}

	@Override
	public List<BloodCenterAppointment> getAllClientAppointment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BloodCenterAppointment> getUpcomingClientAppointment(Long id) {
		RegisteredClient client = registeredClientRepository.findById(id).get();
		List<BloodCenterAppointment> appointments = new ArrayList<>();

		if (client != null) {
			for (BloodCenterAppointment a : client.getBloodCenterAppointments())
				if (!a.getIsCanceled() && (a.getAppointmentStart().isAfter(LocalDateTime.now())
						|| a.getAppointmentStart().isEqual(LocalDateTime.now())))
					appointments.add(a);
		}
		return appointments;
	}

	@Override
	public List<BloodCenterAppointment> getPastClientAppointment(Long id) {
		RegisteredClient client = registeredClientRepository.findById(id).get();
		List<BloodCenterAppointment> appointments = new ArrayList<>();

		if (client != null) {
			for (BloodCenterAppointment a : client.getBloodCenterAppointments())
				if (!a.getIsCanceled() && a.getAppointmentStart().isBefore(LocalDateTime.now()))
					appointments.add(a);
		}
		return appointments;
	}

}
