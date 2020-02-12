package com.hospitalmanagementsystem;

public class Doctor extends Staff{

	private long doctorId;
	private String specialization;

	public Doctor(long doctorId,String firstName, String lastName, String gender, String email) {
		super(doctorId, firstName, lastName, gender, email);
		// TODO Auto-generated constructor stub
	}

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
