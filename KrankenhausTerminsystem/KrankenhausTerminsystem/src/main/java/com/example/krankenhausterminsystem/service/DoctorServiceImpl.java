package com.example.krankenhausterminsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.krankenhausterminsystem.model.Doctor;
import com.example.krankenhausterminsystem.repository.DoctorRepository;
import com.example.krankenhausterminsystem.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).get();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctorById(Long id) {
		doctorRepository.deleteById(id);	
	}

}