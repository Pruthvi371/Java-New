package com.hospitalmanagementsystem;
public class Staff extends User{

	
	private long staffId;
	private int yearOfExperience;
	private String description;
	private double salary;
	
	public Staff(long staffId,String firstName, String lastName, String gender,String email) {
		super(staffId, firstName, lastName, gender,email);
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
