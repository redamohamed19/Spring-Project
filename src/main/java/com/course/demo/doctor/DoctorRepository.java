package com.course.demo.doctor;

import java.util.List; // Correct import

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAllByAge(int age); 
    List<Doctor> findAllByFirstName(String first_name);}
