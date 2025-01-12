package com.siva.hospital.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="fullname", nullable=false, length=40)
	private String fullName;
	@Column(name="email", nullable=false, unique=true, length=50)
	private String email;
	@Column(name="mobile_number", nullable=false, unique=true, length=10)
	private String mobileNumber;
	@Column(name="qualification", nullable=false, length=20)
	private String qualification;
	@Column(name="DOB", nullable=false)
	private Date dob;
	@Column(name="spcialist", nullable=false, length=40)
	private String specialist;
	@Column(name="password", nullable=false, length=30)
	private String password;

}
