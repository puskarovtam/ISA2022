package com.isa.transfuzija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.SystemAdministrator;

@Repository
public interface SystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long> {

}
