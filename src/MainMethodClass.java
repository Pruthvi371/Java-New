import com.flightreservation.TicketReservation;
import com.treesetandcomparator.PubDateAscComparator;
import com.treesetandcomparator.SetDemo;


public class MainMethodClass {

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		TicketReservation tr = new TicketReservation();

		System.out.println(tr.getConfirmedList().size());
//		System.out.println(tr.bookFlight("fn","lastName", 21, "MALE", "Business","as123"));
//
//		System.out.println(tr.getConfirmedList().size());
//		System.out.println(tr.getConfirmedList().get(0).getConfirmationNumber());
//		System.out.println(tr.cancel("as123"));
		
//		System.out.println(tr.getConfirmedList().get(0).getConfirmationNumber());
		
		SetDemo sd = new SetDemo();
		sd.treeSetDemo(new PubDateAscComparator());
//		sd.treeSetDemo(new PubDateDescComparator());
		
		//			sd.hashSetDemo();

	}

}
