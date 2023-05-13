package com.example.krankenhausterminsystem.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.krankenhausterminsystem.model.Doctor;
import com.example.krankenhausterminsystem.service.DoctorService;

@Controller
public class DoctorController {
	
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@GetMapping("/doctor")
	public String listDoctor(Model model) {
		model.addAttribute("doctor", doctorService.getAllDoctor());
		return "doctor";
	}
	
	@GetMapping("/doctor/new")
	public String createDoctorForm(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "addoc";
		
	}
	
	@PostMapping("/doctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return "redirect:/doctor";
	}
	
	@GetMapping("/doctor/edit/{id}")
	public String editDoctorForm(@PathVariable Long id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "editdoc";
	}

	@PostMapping("/doctor/{id}")
	public String updateDoctor(@PathVariable Long id,
			@ModelAttribute("doctor") Doctor doctor,
			Model model) {
		Doctor existingDoctor = doctorService.getDoctorById(id);
		existingDoctor.setId(id);
		existingDoctor.setFirstName(doctor.getFirstName());
		existingDoctor.setLastName(doctor.getLastName());
		existingDoctor.setEmail(doctor.getEmail());
		doctorService.updateDoctor(existingDoctor);
		return "redirect:/doctor";		
	}
	
	@GetMapping("/doctor/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctorById(id);
		return "redirect:/doctor";
	}
	
}