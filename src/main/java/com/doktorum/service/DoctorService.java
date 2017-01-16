package com.doktorum.service;

import org.springframework.stereotype.Service;

import com.doktorum.model.Doctor;

@Service
public class DoctorService {
	
	public Doctor selectTest(){
		Doctor doctor  = new Doctor();
		
		return doctor;
	}
}
