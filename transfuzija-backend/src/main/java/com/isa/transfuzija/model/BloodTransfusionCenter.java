package com.isa.transfuzija.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "blood_transfusion_centers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BloodTransfusionCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transfusion_id")
	private Long id;
	@Column(name = "transfusion_name")
	private String name;
	@Column(name = "transfusion_address")
	private String address;
	@Column(name = "transfusion_city")
	private String city;
	@Column(name = "transfusion_country")
	private String country;
	@Column(name = "transfusion_description")
	private String description;
	@Column(name = "transfusion_rating")
	private Double rating = 0.0;
	@JsonIgnore
	@OneToMany(mappedBy = "transfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BloodCenterAdministrator> bloodCenterAdministrators = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<BloodCenterAppointment> bloodCenterAppointments;

	public BloodTransfusionCenter() {
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

	public List<BloodCenterAdministrator> getBloodCenterAdministrators() {
		return bloodCenterAdministrators;
	}

	public void setBloodCenterAdministrators(List<BloodCenterAdministrator> bloodCenterAdministrators) {
		this.bloodCenterAdministrators = bloodCenterAdministrators;
	}

	public Set<BloodCenterAppointment> getBloodCenterAppointments() {
		return bloodCenterAppointments;
	}

	public void setBloodCenterAppointments(Set<BloodCenterAppointment> bloodCenterAppointments) {
		this.bloodCenterAppointments = bloodCenterAppointments;
	}

}
