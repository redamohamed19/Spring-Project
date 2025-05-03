package com.course.demo.doctor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.course.demo.hospital.Hospital;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DoctorController {

   
    private final DoctorService doctorService;

    public DoctorController( DoctorService doctorService) {
        this.doctorService=doctorService;
    }

    @GetMapping("/doctors")
    public List<DoctorDto> getDoctors() {
        return doctorService.getDoctors();
    }
    
    
    
    
    @GetMapping("/doctors/{doctor-firstName}")
    public List<Doctor> getDoctorByFirstName(@PathVariable("doctor-firstName") String firstName) {
        return doctorService.getDoctorByFirstName(firstName);
    }
    
    @PostMapping("/doctors")
    public Doctor saveDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        return doctorService.saveDoctor(doctorDto);
    }
    
    @DeleteMapping("/doctors/{doctor-id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteDoctorById(@PathVariable("doctor-id") Integer id) {
       doctorService.deleteDoctorById(id);
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
