package com.example.krankenhausterminsystem.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.krankenhausterminsystem.model.Appointment;
import com.example.krankenhausterminsystem.repository.AppointmentRepository;
import com.example.krankenhausterminsystem.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
private AppointmentRepository appointmentRepository;
	
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id).get();
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public void deleteAppointmentById(Long id) {
		appointmentRepository.deleteById(id);	
	}
}
