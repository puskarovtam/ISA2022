package com.isa.transfuzija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.BloodTransfusionCenter;

@Repository
public interface BloodTransfusionCenterRepository extends JpaRepository<BloodTransfusionCenter, Long> {

}
