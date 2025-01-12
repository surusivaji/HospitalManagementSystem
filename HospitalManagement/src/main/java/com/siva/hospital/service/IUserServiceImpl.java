package com.siva.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.siva.hospital.models.User;
import com.siva.hospital.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class IUserServiceImpl implements IUserService  {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		try {
			User save = userRepository.save(user);
			if (save!=null) {
				return save;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public User findByEmailAndPassword(String email, String password) {
		try {
			User user = userRepository.findByEmailAndPassword(email, password);
			if (user!=null) {
				return user;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Long countUsers() {
		long count = userRepository.count();
		return count;
	}
	
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("successMsg");
		session.removeAttribute("failMsg");
		session.removeAttribute("logout");
	}

}
