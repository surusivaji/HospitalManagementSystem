package com.siva.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.Doctor;
import com.siva.hospital.models.Specialist;
import com.siva.hospital.service.IAppointmentService;
import com.siva.hospital.service.IDoctorService;
import com.siva.hospital.service.ISpecialistService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private ISpecialistService specialistService;
	
	@PostMapping("/doctorInformation")
	public String doctorLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		Doctor doctor = doctorService.findByEmailAndPassword(email, password);
		if (doctor!=null) {
			session.setAttribute("doctor", doctor);
			return "redirect:/doctor/home";
		}
		else {
			session.setAttribute("failMsg", "Invalid credientials");
			return "redirect:/doctorlogin";
		}
	}
	
	@GetMapping("/doctor/home")
	public String doctorHomePage(HttpSession session) {
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor!=null) {
			session.setAttribute("fullName", doctor.getFullName());
			Long countDoctors = doctorService.countDoctors();
			session.setAttribute("totalDoctors", countDoctors);
			Long countAppointments = appointmentService.countAppointments();
			session.setAttribute("totalAppointments", countAppointments);
			return "/doctor/home";
		}
		else {
			return "redirect:/doctorlogin";
		}
	}
	
	@GetMapping("/doctor/viewpatients")
	public String viewPatinentDetails(HttpSession session, Model model) {
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor!=null) {
			session.setAttribute("fullName", doctor.getFullName());
			List<Appointment> appointments = appointmentService.findAppointmentsByDoctor(doctor.getId());
			model.addAttribute("appointments", appointments);
			return "/doctor/patients";
		}
		else {
			return "redirect:/doctorlogin";
		}
	}
	
	@GetMapping("/doctor/comment/{id}")
	public String commentPage(HttpSession session, @PathVariable("id") int id, Model model) {
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor!=null) {
			session.setAttribute("fullName", doctor.getFullName());
			Appointment appointment = appointmentService.findAppointmentById(id);
			if (appointment!=null) {
				System.out.println(appointment);
				model.addAttribute("appointment", appointment);
				return "/doctor/comment";
			}
			else {
				session.setAttribute("failMsg", "appointment not found");
				return "redirect:/doctor/viewpatients";
			}
		}
		else {
			return "redirect:/doctorlogin";
		}
	}
	
	@PostMapping("/doctor/updateComment")
	public String updateComment(HttpSession session, @RequestParam("id") int id, @RequestParam("status") String status) {
		Appointment appointment = appointmentService.findAppointmentById(id);
		appointment.setStatus(status);
		Appointment isUpdate = appointmentService.addAppointment(appointment);
		if (isUpdate!=null) {
			session.setAttribute("successMsg", "comment updated");
			return "redirect:/doctor/viewpatients";
		}
		else {
			session.setAttribute("failMsg", "something went wrong");
			return "redirect:/doctor/viewpatients";
		}
	}
	
	@GetMapping("/doctor/editprofile")
	public String editProfile(HttpSession session, Model model) {
	    Doctor doctor = (Doctor) session.getAttribute("doctor");
	    if (doctor != null) {
	    	session.setAttribute("fullName", doctor.getFullName());
	        model.addAttribute("doctorInfo", doctor);
	        List<Specialist> specialists = specialistService.getAllSpecialists();
	        model.addAttribute("specialists", specialists);
	        return "/doctor/editprofile";
	    } else {
	        return "redirect:/doctorlogin";
	    }
	}
	
	@PostMapping("/doctor/updateDoctorInformation")
	public String updateDoctorInformation(HttpSession session, @ModelAttribute Doctor doctor, Model model) {
	    Doctor updatedDoctor = doctorService.addDoctor(doctor); 
	    if (updatedDoctor != null) {
	        session.setAttribute("successMsg", "Doctor information updated successfully");
	        session.setAttribute("doctor", updatedDoctor); 
	    } else {
	        session.setAttribute("failMsg", "Doctor information not updated");
	    }
	    return "redirect:/doctor/editprofile";
	}

	
	@GetMapping("/doctor/logout")	
	public String doctorLogout(HttpSession session) {
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor!=null) {
			session.removeAttribute("doctor");
			session.setAttribute("logout", "doctor logout");
			return "redirect:/doctorlogin";
		}
		else {
			return "redirect:/doctorlogin";
		}
	}
	

}
