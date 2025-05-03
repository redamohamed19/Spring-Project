package com.course.demo.hospital;

import java.util.List;

import org.hibernate.cfg.Environment;

import com.course.demo.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Clinic")
public class Hospital {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "hospital shouldint be empty")
	private String name;
	
	private String adresse;
	
	@OneToMany(mappedBy = "hospital")
	@JsonManagedReference
	private List<Doctor> doctors;
	
	public Hospital() {
	
	}
	
	public Hospital(String name, String adresse, List<Doctor> doctors) {
		this.name = name;
		this.adresse = adresse;
		this.doctors = doctors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}


	

}
