package com.isa.transfuzija.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "system_administrators")
public class SystemAdministrator extends User {

	@Column(name = "system_pass_changed")
	private Boolean passwordChanged;

	public Boolean getPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(Boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

}
