package com.isa.transfuzija.dto;

import java.time.LocalDateTime;

import com.isa.transfuzija.model.BloodCenterAppointment;

public class BloodCenterAppointmentCreateDTO {

	private Long id;
	private LocalDateTime appointmentStart;
	private Double duration;
	private Long centerID;
	private Long clientID;
	private Long stuffID;

	public BloodCenterAppointmentCreateDTO() {
	}

	public BloodCenterAppointmentCreateDTO(BloodCenterAppointment appointment) {
		super();
		this.id = appointment.getId();
		this.appointmentStart = appointment.getAppointmentStart();
		this.duration = appointment.getDuration();
		this.centerID = appointment.getCenter().getId();
		if (appointment.getClient() != null){
			this.clientID = appointment.getClient().getId();
        }
		this.stuffID = appointment.getStuff().getId();
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

	public Long getCenterID() {
		return centerID;
	}

	public void setCenterID(Long centerID) {
		this.centerID = centerID;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getStuffID() {
		return stuffID;
	}

	public void setStuffID(Long stuffID) {
		this.stuffID = stuffID;
	}

}
