package com.siva.hospital.service;

import com.siva.hospital.models.Admin;

public interface IAdminService {
	
	Admin findByEmailAndPassword(String email, String password);
	
}
