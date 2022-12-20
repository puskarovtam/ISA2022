package com.isa.transfuzija.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.model.Role;

public class RegisteredClientDTO extends UserDTO {

	protected Long id;
	protected String email;
	protected String name;
	protected String surname;
	protected String address;
	protected String city;
	protected String country;
	protected String phoneNumber;
	protected List<Role> roles = new ArrayList<>();
	private String jmbg;
	private String gender;
	private String occupation;
	private String jobInformation;
	private Boolean blocked = false;
	private Integer penalties = 0;
	protected Long version;

	public RegisteredClientDTO() {
	}

	public RegisteredClientDTO(RegisteredClient client) {
		super();
		this.id = client.getId();
		this.email = client.getEmail();
		this.name = client.getName();
		this.surname = client.getSurname();
		this.address = client.getAddress();
		this.city = client.getCity();
		this.country = client.getCountry();
		this.phoneNumber = client.getPhoneNumber();
		for (Role r : client.getRoles()) {
			this.roles.add(r);
		}
		this.jmbg = client.getJmbg();
		this.gender = client.getGender();
		this.occupation = client.getOccupation();
		this.jobInformation = client.getJobInformation();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
