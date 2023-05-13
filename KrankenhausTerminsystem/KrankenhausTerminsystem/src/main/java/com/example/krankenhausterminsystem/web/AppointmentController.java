package com.example.krankenhausterminsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.krankenhausterminsystem.model.Appointment;
import com.example.krankenhausterminsystem.service.AppointmentService;

@Controller
public class AppointmentController {
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	@GetMapping("/appointment")
	public String listAppointment(Model model) {
		model.addAttribute("appointment", appointmentService.getAllAppointment());
		return "appointment";
	}
	
	@GetMapping("/appointment/new")
	public String createAppointmentForm(Model model) {
		Appointment appointment = new Appointment();
		model.addAttribute("appointment", appointment);
		return "addappointment";
		
	}
	
	@PostMapping("/appointment")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
		appointmentService.saveAppointment(appointment);
		return "redirect:/appointment";
	}
	
	@GetMapping("/appointment/edit/{id}")
	public String editAppointmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("appointment", appointmentService.getAppointmentById(id));
		return "editappointment";
	}

	@PostMapping("/appointment/{id}")
	public String updateAppointment(@PathVariable Long id,
			@ModelAttribute("appointment") Appointment appointment,
			Model model) {
		Appointment existingAppointment = appointmentService.getAppointmentById(id);
		existingAppointment.setId(id);
		existingAppointment.setPatientName(appointment.getPatientName());
		existingAppointment.setDoctorName(appointment.getDoctorName());
		existingAppointment.setTime(appointment.getTime());
		appointmentService.updateAppointment(existingAppointment);
		return "redirect:/appointment";		
	}
	
	@GetMapping("/appointment/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointmentById(id);
		return "redirect:/appointment";
	}
}
