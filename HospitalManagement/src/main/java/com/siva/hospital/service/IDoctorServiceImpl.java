package com.siva.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.siva.hospital.models.Doctor;
import com.siva.hospital.repository.DoctorRepository;

@Service
public class IDoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	

	@Override
	public Doctor addDoctor(Doctor doctor) {
		try {
			Doctor save = doctorRepository.save(doctor);
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
	public List<Doctor> listOfDocotors() {
		try {
			List<Doctor> list = doctorRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Doctor findById(int id) {
		try {
			Optional<Doctor> optional = doctorRepository.findById(id);
			if (optional.isPresent()) {
				return optional.get();
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
	public boolean removeDoctorById(int id) {
		try {
			Optional<Doctor> optional = doctorRepository.findById(id);
			if (optional.isPresent()) {
				doctorRepository.deleteById(id);
				return true;
			} 
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Doctor findByEmailAndPassword(String email, String password) {
		try {
			Doctor doctor = doctorRepository.findByEmailAndPassword(email, password);
			if (doctor!=null) {
				return doctor;
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
	public Long countDoctors() {
		long count = doctorRepository.count();
		return count;
	}

}
