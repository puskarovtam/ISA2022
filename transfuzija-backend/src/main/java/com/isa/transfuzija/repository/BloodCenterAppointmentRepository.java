package com.isa.transfuzija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.model.BloodTransfusionCenter;

@Repository
public interface BloodCenterAppointmentRepository extends JpaRepository<BloodCenterAppointment, Long> {

	List<BloodCenterAppointment> getByCenterAndClientNullAndIsDeletedFalse(BloodTransfusionCenter center);

}
