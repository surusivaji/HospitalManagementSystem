package com.siva.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.siva.hospital.models.Doctor;
import com.siva.hospital.service.IDoctorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private IDoctorService doctorService;
		
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/userlogin")
	public String userLoginPage() {
		return "userlogin";
	}
	
	@GetMapping("/doctorlogin")
	public String doctorLoginPage() {
		return "doctorlogin";
	}
	
	@GetMapping("/adminlogin")
	public String adminLoginPage() {
		return "adminlogin";
	}
	
	@GetMapping("/register")
	public String registrationPage() {
		return "registeration";
	}
	
	@GetMapping("/appointment")
	public String appointmentPage(HttpSession session, Model model) {
		List<Doctor> doctors = doctorService.listOfDocotors();
		model.addAttribute("doctors", doctors);
		return "appointment";
	}
	
	
	
	

}
