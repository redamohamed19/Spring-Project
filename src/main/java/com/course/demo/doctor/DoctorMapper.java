package com.course.demo.doctor;

import org.springframework.stereotype.Service;

import com.course.demo.hospital.Hospital;

@Service
public class DoctorMapper {
	public DoctorDto toDoctorDto(Doctor doctor) {
    	return new DoctorDto(doctor.getFirstName(), doctor.getLastName(), doctor.getAge(), doctor.getHospital().getId(),doctor.getHospital().getName());
    }
    
    public Doctor toDoctor(DoctorDto doctorDto) {
    	var hospital=new Hospital();
    	hospital.setId(doctorDto.hospitalId());
    	return new Doctor(doctorDto.firstName(), doctorDto.lastName(), doctorDto.age(), null, hospital );
    } 
}
