package com.siva.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.hospital.models.Specialist;
import com.siva.hospital.repository.SpecialistRepository;

@Service
public class ISpecialistServiceImpl implements ISpecialistService {
	
	@Autowired
	private SpecialistRepository specialistRepository;

	@Override
	public Specialist addSpecialist(Specialist specialist) {
		try {
			Specialist save = specialistRepository.save(specialist);
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
	public List<Specialist> getAllSpecialists() {
		try {
			List<Specialist> specialists = specialistRepository.findAll();
			return specialists;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Long countSpecialists() {
		long count = specialistRepository.count();
		return count;
	}
	

}
