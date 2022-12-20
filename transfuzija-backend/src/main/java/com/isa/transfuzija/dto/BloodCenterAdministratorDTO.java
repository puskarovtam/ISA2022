package com.isa.transfuzija.dto;

import com.isa.transfuzija.model.BloodCenterAdministrator;

public class BloodCenterAdministratorDTO extends UserDTO {

	private Long id;
	private String email;
	private String name;
	private String surname;
	private String address;
	private String city;
	private String country;
	private String phoneNumber;

	private Long transfusionCenterId;

	public BloodCenterAdministratorDTO() {
	}

	public BloodCenterAdministratorDTO(BloodCenterAdministrator admin) {
		super();
		this.id = admin.getId();
		this.email = admin.getEmail();
		this.name = admin.getName();
		this.surname = admin.getSurname();
		this.address = admin.getAddress();
		this.city = admin.getCity();
		this.country = admin.getCountry();
		this.phoneNumber = admin.getPhoneNumber();
		this.transfusionCenterId = admin.getTransfusionCenter().getId();
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

	public Long getTransfusionCenterId() {
		return transfusionCenterId;
	}

	public void setTransfusionCenterId(Long transfusionCenterId) {
		this.transfusionCenterId = transfusionCenterId;
	}

}
