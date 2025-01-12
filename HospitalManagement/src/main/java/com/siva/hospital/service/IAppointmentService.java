package com.siva.hospital.service;

import java.util.List;

import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.User;

public interface IAppointmentService {
	
	Appointment addAppointment(Appointment appointment);
	List<Appointment> findAppointmentsByUser(User user);
	List<Appointment> findAppointmentsByDoctor(int id);
	Appointment findAppointmentById(int id);
	List<Appointment> findAllAppointments();
	Long countAppointments();
	
}
