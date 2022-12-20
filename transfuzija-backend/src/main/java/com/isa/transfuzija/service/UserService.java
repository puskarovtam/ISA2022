package com.isa.transfuzija.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.dto.UserDTO;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.SystemAdministrator;
import com.isa.transfuzija.model.User;

public interface UserService {

	UserDTO findById(Long id);

	UserDTO findByEmail(String email);

	List<UserDTO> findAll();

	User save(RegisterDTO userDTO) throws UnsupportedEncodingException;

	User addAdmin(SystemAdministrator admin);

	User addCenterAdmin(BloodCenterAdministrator admin);

}
