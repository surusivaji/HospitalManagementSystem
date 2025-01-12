package com.siva.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.hospital.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	Doctor findByEmailAndPassword(String email, String password);
	
}
