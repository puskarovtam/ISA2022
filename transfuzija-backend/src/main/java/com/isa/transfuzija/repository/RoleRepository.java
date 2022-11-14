package com.isa.transfuzija.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.enums.RoleName;
import com.isa.transfuzija.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Set<Role> findByRoleName(RoleName roleName);

}
