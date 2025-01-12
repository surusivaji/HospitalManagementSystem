package com.siva.hospital.service;

import java.util.List;

import com.siva.hospital.models.Doctor;

public interface IDoctorService {

	Doctor addDoctor(Doctor doctor);
	List<Doctor> listOfDocotors();
	Doctor findById(int id);
	boolean removeDoctorById(int id);
	Doctor findByEmailAndPassword(String email, String password);
	Long countDoctors();
	
}
