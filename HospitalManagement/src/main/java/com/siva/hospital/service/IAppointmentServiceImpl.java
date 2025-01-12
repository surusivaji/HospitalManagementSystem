package com.siva.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.siva.hospital.models.Appointment;
import com.siva.hospital.models.User;
import com.siva.hospital.repository.AppointmentRepository;

@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		try {
			Appointment save = appointmentRepository.save(appointment);
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
	public List<Appointment> findAppointmentsByUser(User user) {
		try {
			List<Appointment> appointments = appointmentRepository.findByUser(user);
			return appointments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Appointment> findAppointmentsByDoctor(int id) {
		try {
			List<Appointment> appointments = appointmentRepository.findByDoctorId(id, Sort.by(Sort.Direction.ASC, "appointmentDate"));
			return appointments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Appointment findAppointmentById(int id) {
		try {
			Optional<Appointment> optional = appointmentRepository.findById(id);
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
	public List<Appointment> findAllAppointments() {
		try {
			List<Appointment> appointments = appointmentRepository.findAll();
			return appointments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Long countAppointments() {
		long count = appointmentRepository.count();
		return count;
	}

}
