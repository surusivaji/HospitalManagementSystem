package com.siva.hospital.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="full_name", length=40, nullable = false)
	private String fullName;
	@Column(name="gender", length=10, nullable = false)
	private String gender;
	@Column(name="age", nullable = false)
	private Integer age;
	@Column(name="appointment_date", nullable = false)
	private Date appointmentDate;
	@Column(name="email", nullable = false, length = 45)
	private String email;
	@Column(name="phone_number", nullable = false, length = 10)
	private String phoneNumber;
	@Column(name="diseases", nullable = false, length = 60)
	private String diseases;
	@Column(name="address", nullable = false, length=150)
	private String address;
	@Column(name="status", nullable = false, length = 40)
	private String status;
	@Column(name="doctor_id", nullable=false)
	private Integer doctorId;
	@ManyToOne
	private User user;

}
