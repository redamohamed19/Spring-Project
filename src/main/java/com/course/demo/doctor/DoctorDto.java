package com.course.demo.doctor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record DoctorDto(
		@NotEmpty()
		 String firstName,
		 @NotEmpty()
		 String lastName,
		 @Min(value = 18,message = "minimum age required is 18")
		 Integer age,
		 Integer hospitalId,
		 String hospitalName
	) {
	
}