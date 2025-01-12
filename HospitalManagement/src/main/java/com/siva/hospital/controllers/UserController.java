package com.siva.hospital.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.Doctor;
import com.siva.hospital.models.User;
import com.siva.hospital.service.IAppointmentService;
import com.siva.hospital.service.IDoctorService;
import com.siva.hospital.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping("/storeUserInformation") 
	public String saveUserInformation(@ModelAttribute User user, HttpSession session) {
		User saveUser = userService.saveUser(user);
		if (saveUser!=null) {
			session.setAttribute("successMsg", "user registration successfully completed");
			return "redirect:/userlogin";
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			return "redirect:/register";
		}
	}
	
	@PostMapping("/saveUserInformation")
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		User login = userService.findByEmailAndPassword(email, password);
		if (login!=null) {
			session.setAttribute("user", login);
			return "redirect:/user/home";
		}
		else {
			session.setAttribute("failMsg", "Invalid credientials");
			return "redirect:/userlogin";
		}
	}
	
	@GetMapping("/user/home")
	public String homePage(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			session.setAttribute("fullName", user.getFullName());
			return "/user/home";
		}
		else {
			return "redirect:/userlogin";
		}
	}
	
	@GetMapping("/user/appiontment")
	public String takeAppointment(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			session.setAttribute("fullName", user.getFullName());
			List<Doctor> doctors = doctorService.listOfDocotors();
			model.addAttribute("doctors", doctors);
			return "/user/user_appointment";
		}
		else {
			return "redirect:/userlogin";
		}
	}
	
	@PostMapping("/saveAppointment")
	public String saveAppointment(HttpSession session, @ModelAttribute Appointment appointment) {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			System.out.println(appointment);
			appointment.setUser(user);
			appointment.setStatus("Pending");
			Appointment isSave = appointmentService.addAppointment(appointment);
			if (isSave!=null) {
				session.setAttribute("successMsg", "appointment added successfully");
				return "redirect:/user/appiontment";
			}
			else {
				session.setAttribute("failMsg", "please check your details");
				return "redirect:/user/appiontment";
			}
		}
		else {
			session.setAttribute("failMsg", "you are not authenticated");
			return "redirect:/userlogin";
		}
	}
	
	@GetMapping("/user/viewappointments")
	public String viewAppointmentDetails(HttpSession session, Model model) {
	    User user = (User) session.getAttribute("user");
	    if (user != null) {
	        session.setAttribute("fullName", user.getFullName());
	        List<Appointment> appointments = appointmentService.findAppointmentsByUser(user);
	        List<Map<String, Object>> appointmentDetails = new ArrayList<>();
	        for (Appointment appointment : appointments) {
	            Doctor doctor = doctorService.findById(appointment.getDoctorId());
	            Map<String, Object> detail = new HashMap<>();
	            detail.put("appointment", appointment);
	            detail.put("doctor", doctor);
	            appointmentDetails.add(detail);
	        }
	        model.addAttribute("appointmentDetails", appointmentDetails);
	        return "/user/viewappointments";
	    } else {
	        return "redirect:/userlogin";
	    }
	}
	
	@GetMapping("/user/changepassword")
	public String changePassword(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			session.setAttribute("fullName", user.getFullName());
			model.addAttribute("email", user.getEmail());
			return "/user/changepassword";
		}
		else {
			return "redirect:/userlogin";
		}
	}
	
	@PostMapping("/user/updatepassword")
	public String updatePassword(HttpSession session, @RequestParam("email") String email, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
		User user = userService.findByEmailAndPassword(email, oldPassword);
		if (user!=null) {
			user.setPassword(newPassword);
			User saveUser = userService.saveUser(user);
			if (saveUser!=null) {
				session.setAttribute("successMsg", "password updated");
				return "redirect:/user/changepassword";
			}
			else {
				session.setAttribute("failMsg", "password is incorrect");
				return "redirect:/user/changepassword";
			}
		}
		else {
			session.setAttribute("failMsg", "password is incorrect");
			return "redirect:/user/changepassword";
		}
	}

	
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			session.removeAttribute("user");
			session.setAttribute("logout", "user logout successfully completed");
			return "redirect:/userlogin";
		}
		else {
			return "redirect:/userlogin";
		}
	}
	
}
