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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siva.hospital.models.Admin;
import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.Doctor;
import com.siva.hospital.models.Specialist;
import com.siva.hospital.service.IAdminService;
import com.siva.hospital.service.IAppointmentService;
import com.siva.hospital.service.IDoctorService;
import com.siva.hospital.service.ISpecialistService;
import com.siva.hospital.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private ISpecialistService specialistService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/adminInformation")
	public String adminInformation(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		Admin admin = adminService.findByEmailAndPassword(email, password);
		if (admin!=null) {
			session.setAttribute("admin", admin);
			return "redirect:/admin/home";
		}
		else {
			session.setAttribute("failMsg", "Invalid credientials");
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/home")
	public String adminHomePage(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			Long countDoctors = doctorService.countDoctors();
			session.setAttribute("totalDoctors", countDoctors);
			Long countUsers = userService.countUsers();
			session.setAttribute("totalUsers", countUsers);
			Long countAppointments = appointmentService.countAppointments();
			session.setAttribute("totalAppointments", countAppointments);
			Long countSpecialists = specialistService.countSpecialists();
			session.setAttribute("totalSpecialists", countSpecialists);
			return "/admin/home";
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@PostMapping("/admin/addSpecialist")
	public String addSpecialist(HttpSession session, @ModelAttribute Specialist specialist) {
		System.out.println(specialist.getSpecialistName());
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			Specialist isSaved = specialistService.addSpecialist(specialist);
			if (isSaved!=null) {
				session.setAttribute("successMsg", "Specilist added successfully");
				return "redirect:/admin/home";
			}
			else {
				session.setAttribute("failMsg", "something went wrong on the server");
				return "redirect:/admin/home";
			}
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/doctors")
	public String displayDoctorsPage(HttpSession session, Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			List<Specialist> spcialists = specialistService.getAllSpecialists();
			model.addAttribute("spcialists", spcialists);
			List<Doctor> doctors = doctorService.listOfDocotors();
			model.addAttribute("doctors",doctors);
			return "/admin/doctor";
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@PostMapping("/admin/storeDoctorInformation")
	public String saveDoctorInformation(HttpSession session, @ModelAttribute Doctor doctor) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			System.out.println(doctor);
			Doctor save = doctorService.addDoctor(doctor);
			if (save!=null) {
				session.setAttribute("successMsg", "doctor added successfully");
				return "redirect:/admin/doctors";
			}
			else {
				session.setAttribute("failMsg", "something went wrong");
				return "redirect:/admin/doctors";
			}
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/editdoctordetails/{id}")
	public String editDoctorDetails(HttpSession session, @PathVariable("id") int id, Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			Doctor doctor = doctorService.findById(id);
			if (doctor!=null) {
				model.addAttribute("doctor", doctor);
				List<Specialist> specialists = specialistService.getAllSpecialists();
				model.addAttribute("specialists", specialists);
				return "/admin/editdoctor";
			}
			else {
				session.setAttribute("failMsg", "doctor was not found");
				return "redirect:/admin/doctors";
			}
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@PostMapping("/admin/updateDoctorInformation")
	public String updateDoctorInformation(HttpSession session, @ModelAttribute Doctor doctor) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			Doctor update = doctorService.addDoctor(doctor);
			if (update!=null) {
				session.setAttribute("successMsg", "doctor information updated");
				return "redirect:/admin/doctors";
			}
			else {
				session.setAttribute("failMsg", "something went wrong");
				return "redirect:/admin/doctors";
			}
		} 
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/removedoctor/{id}")
	public String removeDoctorInformation(HttpSession session, @PathVariable("id") int id) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			boolean isDeleted = doctorService.removeDoctorById(id);
			if (isDeleted) {
				session.setAttribute("successMsg", "doctor removed successfully");
				return "redirect:/admin/doctors";
			}
			else {
				session.setAttribute("failMsg", "doctor not found");
				return "redirect:/admin/doctors";
			}
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/viewpatients")
	public String viewPatients(HttpSession session, Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			List<Appointment> appointments = appointmentService.findAllAppointments();
			if (appointments!=null) {
				List<Map<String, Object>> appointmentDetails = new ArrayList<>();
			    for (Appointment appointment : appointments) {
			    	Doctor doctor = doctorService.findById(appointment.getDoctorId());
			        Map<String, Object> detail = new HashMap<>();
			        detail.put("appointment", appointment);
			        detail.put("doctor", doctor);
			        appointmentDetails.add(detail);
			    }
			    model.addAttribute("appointmentDetails", appointmentDetails);				
				return "/admin/patients";
			}
			else {
				session.setAttribute("failMsg", "there is a issue in the server");
				return "redirect:/admin/home";
			}
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin!=null) {
			session.removeAttribute("admin");
			session.setAttribute("logout", "logout successfully completed");
			return "redirect:/adminlogin";
		}
		else {
			return "redirect:/adminlogin";
		}
	}
	
	
	
	
	

}
