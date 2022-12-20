package com.isa.transfuzija.dto;

import java.time.LocalDateTime;

import com.isa.transfuzija.model.BloodCenterAppointment;

public class BloodCenterAppointmentDTO {

	private Long id;
	private LocalDateTime appointmentStart;
	private Double duration;
	private BloodTransfusionCenterDTO center;
	private RegisteredClientDTO client;
	private BloodCenterAdministratorDTO stuff;

	public BloodCenterAppointmentDTO() {
		super();
	}

	public BloodCenterAppointmentDTO(BloodCenterAppointment appointment) {
		super();
		this.id = appointment.getId();
		this.appointmentStart = appointment.getAppointmentStart();
		this.duration = appointment.getDuration();
		this.center = new BloodTransfusionCenterDTO(appointment.getCenter());
		if (appointment.getClient() != null) {
			this.client = new RegisteredClientDTO(appointment.getClient());
		}
		this.stuff = new BloodCenterAdministratorDTO(appointment.getStuff());
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

	public BloodTransfusionCenterDTO getCenter() {
		return center;
	}

	public void setCenter(BloodTransfusionCenterDTO center) {
		this.center = center;
	}

	public RegisteredClientDTO getClient() {
		return client;
	}

	public void setClient(RegisteredClientDTO client) {
		this.client = client;
	}

	public BloodCenterAdministratorDTO getStuff() {
		return stuff;
	}

	public void setStuff(BloodCenterAdministratorDTO stuff) {
		this.stuff = stuff;
	}

}
