package com.isa.transfuzija.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.transfuzija.model.Role;
import com.isa.transfuzija.model.User;

public class UserDTO {

	protected Long id;
	protected String email;
	protected String name;
	protected String surname;
	protected String address;
	protected String city;
	protected String country;
	protected String phoneNumber;
	protected List<Role> roles = new ArrayList<>();
	protected Long version;

	public UserDTO() {
	}

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.address = user.getAddress();
		this.city = user.getCity();
		this.country = user.getCountry();
		this.phoneNumber = user.getPhoneNumber();
		for (Role r : user.getRoles()) {
			this.roles.add(r);
		}
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
