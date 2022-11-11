package com.isa.transfuzija.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blood_center_administrators")
public class BloodCenterAdministrator extends User {

	@Column(name = "center_pass_changed")
	private Boolean passwordChanged;
	@ManyToOne(fetch = FetchType.LAZY)
	private BloodTransfusionCenter transfusionCenter;

	public Boolean getPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(Boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

	public BloodTransfusionCenter getTransfusionCenter() {
		return transfusionCenter;
	}

	public void setTransfusionCenter(BloodTransfusionCenter transfusionCenter) {
		this.transfusionCenter = transfusionCenter;
	}

}
