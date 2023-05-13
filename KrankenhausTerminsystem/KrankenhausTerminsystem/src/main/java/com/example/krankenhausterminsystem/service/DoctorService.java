package com.example.krankenhausterminsystem.service;
import java.util.List;

import com.example.krankenhausterminsystem.model.Doctor;

public interface DoctorService {
	List<Doctor> getAllDoctor();
	
	Doctor saveDoctor(Doctor doctor);
	
	Doctor getDoctorById(Long id);
	
	Doctor updateDoctor(Doctor doctor);
	
	void deleteDoctorById(Long id);
}