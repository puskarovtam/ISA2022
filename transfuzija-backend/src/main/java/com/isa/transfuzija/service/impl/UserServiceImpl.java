package com.isa.transfuzija.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.model.Role;
import com.isa.transfuzija.model.User;
import com.isa.transfuzija.repository.RegisteredClientRepository;
import com.isa.transfuzija.repository.UserRepository;
import com.isa.transfuzija.service.RoleService;
import com.isa.transfuzija.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RegisteredClientRepository registeredClientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleService roleService;

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseGet(null);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(RegisterDTO userDTO) {
//		User u = new User();
//		
//		u.setEmail(userDTO.getEmail());
//		u.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//		u.setName(userDTO.getName());
//		u.setSurname(userDTO.getSurname());
//		u.setAddress(userDTO.getAddress());
//		u.setCity(userDTO.getCity());
//		u.setCountry(userDTO.getCountry());
//		u.setPhoneNumber(userDTO.getPhoneNumber());
//		u.setEnabled(false);
//		//Set<Role> roles =

		RegisteredClient rc = new RegisteredClient();
		rc.setEmail(userDTO.getEmail());
		rc.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		rc.setName(userDTO.getName());
		rc.setSurname(userDTO.getSurname());
		rc.setAddress(userDTO.getAddress());
		rc.setCity(userDTO.getCity());
		rc.setCountry(userDTO.getCountry());
		rc.setPhoneNumber(userDTO.getPhoneNumber());
		rc.setEnabled(false);
		rc.setJmbg(userDTO.getJmbg());
		rc.setGender(userDTO.getGender());
		rc.setOccupation(userDTO.getOccupation());
		rc.setJobInformation(userDTO.getJobInformation());
		rc.setBlocked(false);
		rc.setPenalties(0);

		return registeredClientRepository.save(rc);
	}

}
