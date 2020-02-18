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
				if (studentsGrades[i][j] == ' ') {
						throw new MissingGradeException(studentIdList[i]);
	                }
				
			}

			studentsGpa[i] = gpaSum/totGrads;
		}

		return studentsGpa;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws Throwable {

		if( (lower < 0) || (higher < 0) || (lower > higher) ) 
			return null;

		int reqstudno = 0;
		double[] studGpa = new double[studentIdList.length];
		
			try {
				studGpa = calculateGPA(studentIdList, studentsGrades);
			}  catch (MissingGradeException e) {
				e.printStackTrace();
				System.out.println("error at  "+e.getMessage());
				throw new InvalidDataException().getCause();
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

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		int[] studentIdList = {1001,1002};

		char[][] studentsGrades = {{'A','B'},{'A'}};

		double[] d = null;
		
		d = calculateGPA(studentIdList, studentsGrades);
		System.out.println("GPA for id "+studentIdList[0]+" is "+d[0]);

		int[] i = null;
		try {
			i = getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("The id of the student with gpa between 3.2 and 3.5 is  "+i[0]);
	}

}
