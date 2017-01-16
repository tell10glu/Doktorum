package com.doktorum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private String surname;
	private Date age;
	
}
