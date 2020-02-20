package com.flightreservation;

import java.util.ArrayDeque;
import java.util.ArrayList; 
import java.util.Deque; 
import java.util.Iterator; 
import java.util.List;

public class TicketReservation {

	private static final int CONFIRMEDLIST_LIMIT = 10;
	private static final int WAITINGLIST_LIMIT = 3;

	private List<Passenger> confirmedList = new ArrayList<>();
	private Deque<Passenger> waitingList = new ArrayDeque<>();

	public List<Passenger> getConfirmedList() {
		return confirmedList;     
	}

	public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,String confirmationNumber) {
		
		Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass,
				confirmationNumber);
		if(confirmedList.size()<CONFIRMEDLIST_LIMIT) {
			confirmedList.add(passenger);
			return true;
		}
		else if(confirmedList.size()==CONFIRMEDLIST_LIMIT && waitingList.size()<WAITINGLIST_LIMIT){
			waitingList.add(passenger);
			return true;
		}
		
		return false; 
	}

	public boolean cancel(String confirmationNumber) {
		
		Iterator<Passenger> iterator = confirmedList.iterator();
		Iterator<Passenger> iterator1 = waitingList.iterator();

		while (iterator.hasNext()) {
        	if((iterator.next().getConfirmationNumber().equals(confirmationNumber)) && waitingList.isEmpty()) {
        		return removePassenger(confirmedList.iterator(), confirmationNumber);
        	}
        	else if((iterator.next().getConfirmationNumber().equals(confirmationNumber)) && !(waitingList.isEmpty())) {
        		if(removePassenger(confirmedList.iterator(), confirmationNumber)) {
        			confirmedList.add(waitingList.poll());
        			return true;
        		}
        	}
        	else {
        		while(iterator1.hasNext()) {
        			if(iterator1.next().getConfirmationNumber().equals(confirmationNumber)) {
        				return removePassenger(waitingList.iterator(), confirmationNumber);
        			}
        		}
        	}
        }	
		return false;	

	}
 
	public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
		while (iterator.hasNext()) {
	        	if(iterator.next().getConfirmationNumber().equals(confirmationNumber)) {
	        		iterator.remove();
	        		return true;
	        	}
		 }
		return false;         
	}

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		TicketReservation tr = new TicketReservation();

		System.out.println("has Ticket booked? =>  "+tr.bookFlight("fn","lastName", 21, "MALE", "Business","as123"));
		System.out.println("Has ticket cancelled "+tr.cancel("a123"));
		
	}
	
}
