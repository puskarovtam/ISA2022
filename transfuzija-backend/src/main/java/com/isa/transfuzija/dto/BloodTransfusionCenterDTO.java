package com.isa.transfuzija.dto;

import com.isa.transfuzija.model.BloodTransfusionCenter;

public class BloodTransfusionCenterDTO {

	private Long id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String description;
	private Double rating = 0.0;

	public BloodTransfusionCenterDTO() {
	}

	public BloodTransfusionCenterDTO(BloodTransfusionCenter center) {
		this.id = center.getId();
		this.name = center.getName();
		this.address = center.getAddress();
		this.city = center.getCity();
		this.country = center.getCountry();
		this.description = center.getDescription();
		this.rating = center.getRating();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

}
