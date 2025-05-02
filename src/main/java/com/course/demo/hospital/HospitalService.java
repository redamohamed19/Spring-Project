package com.course.demo.hospital;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	private HospitalRepository hospitalRepository;

	public HospitalService(HospitalRepository hospitalRepository) {
	
		this.hospitalRepository = hospitalRepository;
	}
	
    @Value("${hospital-adresse}")
    private String hospitalAdresse;
	
	 public List<Hospital> getHospitals() {
	        return hospitalRepository.findAll();
	    }
	 
	 public Hospital saveHospital( Hospital hospital) {
		 hospital.setAdresse(hospitalAdresse);
	        return hospitalRepository.save(hospital);
	    }
}

