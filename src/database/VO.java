package database;

import businessLogic.Flight;
import businessLogic.User;
import javafx.collections.ObservableList;

public class VO {

	User user;
	ObservableList<Flight> flight;
	Flight fl;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ObservableList<Flight> getFlight() {
		return flight;
	}


	public void setFlight(ObservableList<Flight> flight) {
		this.flight = flight;
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
	
	
	public VO(ObservableList<Flight> flight) {
		this.flight = flight;
	}


	public void setFl(String flightid) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "VO [user=" + user + ", flight=" + flight + ", fl=" + fl + "]";
	}
	
	
	
	
	
}
