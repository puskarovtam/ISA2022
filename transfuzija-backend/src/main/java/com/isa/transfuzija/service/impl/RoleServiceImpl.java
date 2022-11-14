package com.isa.transfuzija.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.enums.RoleName;
import com.isa.transfuzija.model.Role;
import com.isa.transfuzija.repository.RoleRepository;
import com.isa.transfuzija.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<Role> findById(Long id) {
		Optional<Role> role = roleRepository.findById(id); 
		return role;
	}

	@Override
	public Set<Role> findByName(RoleName name) {
		return roleRepository.findByRoleName(name);
	}

}
