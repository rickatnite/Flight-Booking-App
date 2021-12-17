package database;

import businessLogic.Flight;
import businessLogic.User;
import javafx.collections.ObservableList;

public class VO {

	static User user;
	ObservableList<Flight> flights;
	static Flight fl;
	
	
	public static User getUser() {
		return user;
	}


	public void setUser(User user) {
		VO.user = user;
	}


	public ObservableList<Flight> getFlight() {
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
	
	
	
	
	
}
