package com.example.krankenhausterminsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "patientName", nullable = false)
	private String patientName;
	
	@Column(name = "doctorName")
	private String doctorName;
	
	@Column(name = "time")
	private String time;
	
	public Appointment() {
		
	}
	
	public Appointment(Long id,String patientName, String doctorName, String time) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.time= time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
