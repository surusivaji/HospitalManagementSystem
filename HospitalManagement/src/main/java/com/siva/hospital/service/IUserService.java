package com.siva.hospital.service;

import com.siva.hospital.models.User;

public interface IUserService {
	
	User saveUser(User user);
	User findByEmailAndPassword(String email, String password);
	Long countUsers();
	
}
