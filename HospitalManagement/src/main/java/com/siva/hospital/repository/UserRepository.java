package com.siva.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.hospital.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email, String password);

}
