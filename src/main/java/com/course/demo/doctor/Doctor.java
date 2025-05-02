package com.course.demo.doctor;

import com.course.demo.hospital.Hospital;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	@Column(name = "salary")
	private Double pay;
	
	@ManyToOne()
	@JoinColumn(name = "hospitalId")
	@JsonBackReference
	private Hospital hospital;
	




	public Doctor() {
		
	}
	public Doctor(String firstName, String lastName, Integer age, Double pay, Hospital hospital) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.pay = pay;
		this.hospital = hospital;
	}





	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}
	public Hospital getHospital() {
		return hospital;
	}



	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}
