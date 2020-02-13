import java.util.Arrays;

import com.apiresponseparser.APIResponseParser;
import com.apiresponseparser.Book;
import com.flightreservation.TicketReservation;
import com.hms.billingcomponent.Billing;
import com.hms.billingcomponent.BlueCrossBlueShield;
import com.hms.billingcomponent.HealthInsurancePlan;
import com.hms.billingcomponent.InsuranceBrand;
import com.hms.billingcomponent.PlatinumPlan;
import com.hospitalmanagementsystem.Patient;
import com.hospitalmanagementsystem.User;
import com.studentutil.computegpa.StudentUtil;
import com.treesetandcomparator.SetDemo;


public class MainMethodClass {

	public static void main(String[] args) throws ClassNotFoundException, Exception {


		//		Below StudentUtil Class output has been printed 

		int[] studentIdList = {1001,1002};

		char[][] studentsGrades = {{'A','B'},{'A'}};

		double[] d =StudentUtil.calculateGPA(studentIdList, studentsGrades);
		System.out.println(d[0]);

		int [] i = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
		System.out.println(i[0]);




		//		Below code is for printing the output of SentimentAnalyzer Class

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


		//		 Top print output of ApiResponseParser Class exercise

		String response = "<work>" + 
				"<id type=\"integer\">2361393</id>" +
				"<books_count type=\"integer\">813</books_count>" +
				"<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
				"<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
				"<original_publication_year type=\"integer\">1854</original_publication_year>" +
				"<original_publication_month type=\"integer\" nil=\"true\"/>" +
				"<original_publication_day type=\"integer\" nil=\"true\"/>" +
				"<average_rating>3.79</average_rating>" +
				"<best_book type=\"Book\">" +
				"<id type=\"integer\">16902</id>" +
				"<title>Walden</title>" + 
				"<author>" +
				"<id type=\"integer\">10264</id>" + 
				"<name>Henry David Thoreau</name>" + 
				"</author>" +
				"<image_url>" + 
				"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
				"</image_url>" +
				"<small_image_url>" + 
				"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
				"</small_image_url>" +
				"</best_book>" +
				"</work>";

		Book b = APIResponseParser.parse(response);
		System.out.println(b.getRatingsCount());


//		Code for com.hms.billingcomponent

		HealthInsurancePlan insurancePlan = new PlatinumPlan();
		Patient patient = new Patient();
		patient.setInsurancePlan(insurancePlan);
		double [] payments = Billing.computePaymentAmount(patient, 1000);

		System.out.println("Amount need to paid by Insurance company "+payments[0]
				+" and the patient has to pay "+payments[1]);


		User staff = new User();
		InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
		HealthInsurancePlan insurancePlan1 = new PlatinumPlan();
		insurancePlan1.setOfferedBy(insuranceBrand);
		staff.setInsurancePlan(insurancePlan1);
		System.out.println("Premium Amount Of Staff is "+((PlatinumPlan) insurancePlan1).computeMonthlyPremium(5000,56,true));

		TicketReservation tr = new TicketReservation();

		System.out.println(tr.getConfirmedList().size());
		System.out.println(tr.bookFlight("fn","lastName", 21, "MALE", "Business","as123"));

		System.out.println(tr.getConfirmedList().size());
		System.out.println(tr.getConfirmedList().get(0).getConfirmationNumber());
		System.out.println(tr.cancel("as123"));
		
		System.out.println(tr.getConfirmedList().get(0).getConfirmationNumber());
		
		SetDemo sd = new SetDemo();
//			sd.hashSetDemo();

	}

}
