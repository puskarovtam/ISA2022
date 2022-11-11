package com.isa.transfuzija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.BloodCenterAdministrator;

@Repository
public interface BloodCenterAdministratorRepository extends JpaRepository<BloodCenterAdministrator, Long> {

}
