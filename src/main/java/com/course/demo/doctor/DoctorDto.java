package com.course.demo.doctor;

public record DoctorDto(

		 String firstName,
		 String lastName,
		 Integer age,
		 Integer hospitalId,
		 String hospitalName
	) {
	
}