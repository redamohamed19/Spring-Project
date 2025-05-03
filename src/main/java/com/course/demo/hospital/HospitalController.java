package com.course.demo.hospital;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
public class HospitalController {
	
	
	
	@Autowired private HospitalService hospitalService;
	
	
	
	@GetMapping("/hospitals")
    private List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }
	
	@PostMapping("/hospitals")
    private Hospital saveHospital(@Valid @RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
		
		var errors= new HashMap<String, String>();
		exp.getBindingResult().getAllErrors().forEach(error-> {
			var fieldName = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
    
  
    
    
}
