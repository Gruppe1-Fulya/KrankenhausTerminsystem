package com.example.krankenhausterminsystem.service;

import java.util.List;

import com.example.krankenhausterminsystem.model.Appointment;

public interface AppointmentService {
	
	List<Appointment> getAllAppointment();
	
	Appointment saveAppointment(Appointment appointment);
	
	Appointment getAppointmentById(Long id);
	
	Appointment updateAppointment(Appointment appointment);
	
	void deleteAppointmentById(Long id);
}
