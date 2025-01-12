package com.siva.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.hospital.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmailAndPassword(String email, String password);

}
