package com.hospitalmanagementsystem;

import com.hms.billingcomponent.HealthInsurancePlan;

public class Patient extends User {

	
	private int  patientid;
	private Boolean insured;
	private HealthInsurancePlan insurancePlan;
	
//	public Patient(String firstName, String lastName, String gender, String email) {
//		super(firstName, lastName, gender, email);
//		// TODO Auto-generated constructor stub
//	}
	
	
//	public Patient() {
//		// TODO Auto-generated constructor stub
//		super();
//	}


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
		return insurancePlan;
	}
	public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
	
	
	
}
