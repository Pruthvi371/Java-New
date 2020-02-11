package com.hospitalmanagementsystem;
public class Nurse extends Staff {

	public Nurse(String firstName, String lastName, String gender, String email) {
		super(firstName, lastName, gender, email);
		// TODO Auto-generated constructor stub
	}

	private int nurseId;

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}
}
