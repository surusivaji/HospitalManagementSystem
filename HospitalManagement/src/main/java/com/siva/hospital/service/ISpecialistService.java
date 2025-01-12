package com.siva.hospital.service;

import java.util.List;

import com.siva.hospital.models.Specialist;

public interface ISpecialistService {
	
	Specialist addSpecialist(Specialist specialist);
	List<Specialist> getAllSpecialists();
	Long countSpecialists();

}
