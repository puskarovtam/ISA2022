package com.isa.transfuzija.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registered_clients")
public class RegisteredClient extends User {

	@Column(name = "registered_jmbg")
	private String jmbg;
	@Column(name = "registered_gender")
	private String gender;
	@Column(name = "registered_occupation")
	private String occupation;
	@Column(name = "registered_job_information")
	private String jobInformation;
	@Column(name = "registered_blocked")
	private Boolean blocked = false;
	@Column(name = "registered_penalties")
	private Integer penalties = 0;

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getJobInformation() {
		return jobInformation;
	}

	public void setJobInformation(String jobInformation) {
		this.jobInformation = jobInformation;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Integer getPenalties() {
		return penalties;
	}

	public void setPenalties(Integer penalties) {
		this.penalties = penalties;
	}

}
