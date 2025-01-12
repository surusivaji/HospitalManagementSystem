package com.siva.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.hospital.models.Specialist;

public interface SpecialistRepository extends JpaRepository<Specialist, Integer> {

}
