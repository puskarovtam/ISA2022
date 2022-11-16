package com.isa.transfuzija.service;

import java.util.List;

import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.SystemAdministrator;
import com.isa.transfuzija.model.User;

public interface UserService {

	User findById(Long id);

	User findByEmail(String email);

	List<User> findAll();

	User save(RegisterDTO userDTO);

	User addAdmin(SystemAdministrator admin);

	User addCenterAdmin(BloodCenterAdministrator admin);

}