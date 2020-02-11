package com.hospitalmanagementsystem;
public class Doctor extends Staff{

	public Doctor(String firstName, String lastName, String gender, String email) {
		super(firstName, lastName, gender, email);
		// TODO Auto-generated constructor stub
	}
	private long doctorId;
	private String specialization;
	public long getDoctorid() {
		return doctorId;
	}
	public void setDoctorid(long doctorid) {
		this.doctorId = doctorid;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}
