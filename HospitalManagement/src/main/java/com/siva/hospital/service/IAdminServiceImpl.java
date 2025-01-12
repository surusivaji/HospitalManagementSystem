package com.siva.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.hospital.models.Admin;
import com.siva.hospital.repository.AdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		try {
			Admin admin = adminRepository.findByEmailAndPassword(email, password);
			if (admin!=null) {
				return admin;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
