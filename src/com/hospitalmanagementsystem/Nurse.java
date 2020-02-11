package com.hospitalmanagementsystem;
public class Nurse extends Staff {

	

	private long nurseId;

	public Nurse(long nurseId,String firstName, String lastName, String gender, String email) {
		super(nurseId, firstName, lastName, gender, email);
		// TODO Auto-generated constructor stub
	}
	
	public long getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}
}
