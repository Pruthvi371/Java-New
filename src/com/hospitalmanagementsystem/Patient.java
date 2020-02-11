package com.hospitalmanagementsystem;

import com.hms.billingcomponent.HealthInsurancePlan;

public class Patient extends User {

	public Patient(String firstName, String lastName, String gender, String email) {
		super(firstName, lastName, gender, email);
		// TODO Auto-generated constructor stub
	}
	private int  patientid;
	Boolean insured;
	
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public Boolean getInsured() {
		return insured;
	}
	public void setInsured(Boolean insured) {
		this.insured = insured;
	}
	public HealthInsurancePlan getInsurancePlan() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
