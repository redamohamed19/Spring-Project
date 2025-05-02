package com.course.demo.doctor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	private final DoctorMapper doctorMapper;
	 private final DoctorRepository doctorRepository;
	public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
		this.doctorMapper = doctorMapper;
		this.doctorRepository = doctorRepository;
	}
	
	 public List<DoctorDto> getDoctors() {
	        return doctorRepository.findAll().stream().map(doctorMapper::toDoctorDto).collect(Collectors.toList());
	    }
	 
	 
	 public List<Doctor> getDoctorByFirstName(String firstName) {
	        return doctorRepository.findAllByFirstName(firstName);
	    }
	 
	 public Doctor saveDoctor( DoctorDto doctorDto) {
	    	var doctor=this.doctorMapper.toDoctor(doctorDto);
	        return doctorRepository.save(doctor);
	    }
	 
	 public void deleteDoctorById( Integer id) {
	       doctorRepository.deleteById(id);
	    }
}
