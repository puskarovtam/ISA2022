package com.isa.transfuzija.service;

import java.util.Optional;
import java.util.Set;

import com.isa.transfuzija.enums.RoleName;
import com.isa.transfuzija.model.Role;

public interface RoleService {

	Optional<Role> findById(Long id);

	Set<Role> findByName(RoleName role);

}
