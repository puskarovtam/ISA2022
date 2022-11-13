package com.isa.transfuzija.service;

import java.util.Optional;

import com.isa.transfuzija.model.Role;

public interface RoleService {

	Optional<Role> findById(Long id);

	Optional<Role> findByName(String name);

}
