package com.studentutil.computegpa;

@SuppressWarnings("serial")

public class MissingGradeException  extends Exception {

	private long studentId;
	
	public long getStudentId() {
		return studentId;
	}

	public MissingGradeException( long studentId) {
		this.studentId = studentId;
	}
}
