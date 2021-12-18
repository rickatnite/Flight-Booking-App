package database;

import businessLogic.Booking;
import businessLogic.Flight;
import businessLogic.User;
import javafx.collections.ObservableList;

public class VO {

	static User user;
	static ObservableList<Flight> flights;
	static Flight fl;
	static Booking bk;
	static ObservableList<Booking> bookings;
	
	
	public static User getUser() {
		return user;
	}


	public void setUser(User user) {
		VO.user = user;
	}


	public static ObservableList<Flight> getFlight() {
		return flights;
	}


	public void setFlight(ObservableList<Flight> flights) {
		this.flights = flights;
	}


	public Flight getFl() {
		return fl;
	}


	public void setFl(Flight fl) {
		this.fl = fl;
	}


	
//	ObservableList<Flight> flightToAdd;
//	ObservableList<Flight> flightToDelete;
	
	
	
	public VO() {
	}
	
	
	public VO(ObservableList<Flight> flights) {
		this.flights = flights;
	}


	public void setFl(String flightid) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "VO [user=" + user + ", flight=" + flights + ", fl=" + fl + "]";
	}


	public static ObservableList<Flight> getFlights() {
		return flights;
	}


	public static void setFlights(ObservableList<Flight> flights) {
		VO.flights = flights;
	}


	public static Booking getBk() {
		return bk;
	}


	public static void setBk(Booking bk) {
		VO.bk = bk;
	}


	public static ObservableList<Booking> getBookings() {
		return bookings;
	}


	public static void setBookings(ObservableList<Booking> bookings) {
		VO.bookings = bookings;
	}
	
	
	
	
	
}
