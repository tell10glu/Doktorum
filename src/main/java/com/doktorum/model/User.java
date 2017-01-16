package com.doktorum.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String email;
	private String password;
	private boolean doctor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDoctor() {
		return doctor;
	}
	public void setDoctor(boolean doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", doctor=" + doctor + "]";
	}
}
