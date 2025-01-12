package com.siva.hospital.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.User;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByUser(User user);
	List<Appointment> findByDoctorId(Integer id, Sort sort);
	
}
