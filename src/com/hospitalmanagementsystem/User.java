package com.hospitalmanagementsystem;

import com.hms.billingcomponent.HealthInsurancePlan;

public class User {
    
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Boolean insured;
	private HealthInsurancePlan insurancePlan;
	
	public User(long id,String firstName, String lastName, String gender, String email) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getInsured() {
		return insured;
	}
	public void setInsured(Boolean insured) {
		this.insured = insured;
	}
	
	public HealthInsurancePlan getInsurancePlan() {
		return insurancePlan;
	}
	public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
	
	
	
}