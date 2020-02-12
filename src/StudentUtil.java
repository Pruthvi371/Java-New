

public class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {


		int totStudents = studentIdList.length;
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
			}

			studentsGpa[i] = gpaSum/totGrads;

		}

		return studentsGpa;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {

		if( (lower < 0) || (higher < 0) || (lower > higher) ) 
			return null;

		int reqstudno = 0;
		double [] studGpa = calculateGPA(studentIdList, studentsGrades);
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
