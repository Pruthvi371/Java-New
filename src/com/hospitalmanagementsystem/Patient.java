package com.hospitalmanagementsystem;

public class Patient extends User {

	
	private int  patientid;
	
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
	
}
