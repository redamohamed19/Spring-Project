package com.course.demo.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HospitalController {
	
	
	
	@Autowired private HospitalService hospitalService;
	
	
	
	


	@GetMapping("/hospitals")
    private List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }
	
	@PostMapping("/hospitals")
    private Hospital saveHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }
    
  
    
    
}
