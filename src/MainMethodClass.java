import java.util.Arrays;


public class MainMethodClass {

	public static void main(String[] args) {
		

		/*
		*
		*Below StudentUtil Class output has been printed 
		*
		 **/
		
		int[] studentIdList = {1001,1002};
		
		char[][] studentsGrades = {{'A','B'},{'A'}};
		
		double[] d =StudentUtil.calculateGPA(studentIdList, studentsGrades);
		System.out.println(d[0]);
		
		int [] i = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
		System.out.println(i[0]);
		
		
		
		/*
		 * 
		 *Below code is for printing the output of SentimentAnalyzer Class
		 *
		 */
		
		
//		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive".toLowerCase();
		
		String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.".toLowerCase();
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = SentimentAnalyzer.detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));

	}

}
