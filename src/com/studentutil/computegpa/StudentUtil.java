package com.studentutil.computegpa;


public class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {


		int totStudents = studentIdList.length;
		
		if(totStudents!=studentsGrades.length) {
			throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync.  studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length) ;
		}
		
		double[] studentsGpa = new double[totStudents];
		for(int i = 0 ; i < totStudents  ;i++) {
			double gpaSum = 0;
			double totGrads = studentsGrades[i].length;

			for(int j =0;j<totGrads;j++) {
				if (studentsGrades[i][j] == 'A')
					gpaSum+=4;
				if (studentsGrades[i][j] == 'B')
					gpaSum+=3;
				if (studentsGrades[i][j] == 'C')
					gpaSum+=2;
				else if (studentsGrades[i][j] == ' ') {
					throw new MissingGradeException(studentIdList[i]);
                }
			}

			studentsGpa[i] = gpaSum/totGrads;

		}

		return studentsGpa;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws InvalidDataException {

		if( (lower < 0) || (higher < 0) || (lower > higher) ) 
			return null;

		int reqstudno = 0;
		double[] studGpa = new double[studentIdList.length];
		
		try {
			studGpa = calculateGPA(studentIdList, studentsGrades);
		} catch (MissingGradeException e) {
			System.out.println("Grade for the id "+e.getStudentId()+" is missing");
			e.printStackTrace();
			throw new InvalidDataException(); 
		}

		for(int i = 0 ; i<studentIdList.length ; i++) {
			if(lower<= studGpa[i] && studGpa[i]<= higher)
				reqstudno++;
		}

		int getStudentsByGpa[] = new int [reqstudno];

		for(int j = 0 ; j<studentIdList.length ; j++) {
			if(lower<= studGpa[j] && studGpa[j]<= higher)
				getStudentsByGpa[j] = studentIdList[j];
		}

		return getStudentsByGpa;
	}


}
