package com.isa.transfuzija.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "blood_center_appointments")
public class BloodCenterAppointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long id;
	@Column(name = "appointment_start")
	private LocalDateTime appointmentStart;
	@Column(name = "appointment_duration")
	private Double duration;
	@ManyToOne
	@JoinColumn(name = "center_id")
	@JsonBackReference
	private BloodTransfusionCenter center;
	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonBackReference
	private RegisteredClient client;
	@ManyToOne
	@JoinColumn(name = "center_admin_id", nullable = false)
	private BloodCenterAdministrator stuff;
	@Column(name = "appointment_is_completed")
	private Boolean isCompleted = false;
	@Column(name = "appointment_is_canceled")
	private Boolean isCanceled = false;
	@Column(name = "appointment_is_deleted")
	private Boolean isDeleted = false;

	public BloodCenterAppointment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getAppointmentStart() {
		return appointmentStart;
	}

	public void setAppointmentStart(LocalDateTime appointmentStart) {
		this.appointmentStart = appointmentStart;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public BloodTransfusionCenter getCenter() {
		return center;
	}

	public void setCenter(BloodTransfusionCenter center) {
		this.center = center;
	}

	public RegisteredClient getClient() {
		return client;
	}

	public void setClient(RegisteredClient client) {
		this.client = client;
	}

	public BloodCenterAdministrator getStuff() {
		return stuff;
	}

	public void setStuff(BloodCenterAdministrator stuff) {
		this.stuff = stuff;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
