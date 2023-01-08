package com.isa.transfuzija.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.BloodCenterAppointment;
import com.isa.transfuzija.model.BloodTransfusionCenter;

@Repository
public interface BloodCenterAppointmentRepository extends JpaRepository<BloodCenterAppointment, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT a from BloodCenterAppointment a where a.id = :id")
	@QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = "0") })
	BloodCenterAppointment findOneById(Long id);

	List<BloodCenterAppointment> getByCenterAndClientNullAndIsDeletedFalse(BloodTransfusionCenter center);

}
