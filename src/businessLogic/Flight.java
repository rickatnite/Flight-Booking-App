package businessLogic;

import java.util.Random;
import database.Insert; 
import javafx.beans.property.SimpleStringProperty; 

public class Flight {


	private SimpleStringProperty ticketid;
	private SimpleStringProperty userid;
	private SimpleStringProperty flightid;
	private SimpleStringProperty departAirport;
	private SimpleStringProperty departDate;
	private SimpleStringProperty departTime;
	private SimpleStringProperty arrivalAirport;
	private SimpleStringProperty arrivalDate;
	private SimpleStringProperty arrivalTime;

	public Flight() {
	}
	
	
	public Flight(String flightid, String ticketid, String userid) {
		this.flightid = new SimpleStringProperty(flightid);
		this.ticketid = new SimpleStringProperty(ticketid);
		this.userid = new SimpleStringProperty(userid);
	}
	
	
	public Flight(String flightid, String departAirport, String departDate, String departTime, String arrivalAirport, String arrivalDate, String arrivalTime) {
		
		this.flightid = new SimpleStringProperty(flightid);
		this.departAirport = new SimpleStringProperty(departAirport);
		this.departDate = new SimpleStringProperty(departDate);
		this.departTime = new SimpleStringProperty(departTime);
		this.arrivalAirport = new SimpleStringProperty(arrivalAirport);
		this.arrivalDate = new SimpleStringProperty(arrivalDate);
		this.arrivalTime = new SimpleStringProperty(arrivalTime);
	}
	
	
	
//	public String getuserid() {
//		return flightid.get();
//	}
//
//	public void setFlightid(String flightid) {
//		this.flightid.set(flightid);
//	}
//
//	
	
	//getter/setters
	//this no working
	public String getFlightid() {
		return flightid.get();
	}

	public void setFlightid(String flightid) {
		this.flightid.set(flightid);
	}

	public String getDepartAirport() {
		return departAirport.get();
	}

	public void setDepartAirport(String departAirport) {
		this.departAirport.set(departAirport);
	}

	public String getDepartDate() {
		return departDate.get();
	}

	public void setDepartDate(String departDate) {
		this.departDate.set(departDate);
	}

	public String getDepartTime() {
		return departTime.get();
	}

	public void setDepartTime(String departTime) {
		this.departTime.set(departTime);
	}

	public String getArrivalAirport() {
		return arrivalAirport.get();
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport.set(arrivalAirport);
	}

	public String getArrivalDate() {
		return arrivalDate.get();
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate.set(arrivalDate);
	}

	public String getArrivalTime() {
		return arrivalTime.get();
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime.set(arrivalTime);
	}

	//create toStrings
	@Override
	public String toString() {
		return "Flight [departAirport=" + departAirport + ", departDate=" + departDate
				+ ", departTime=" + departTime + ", arrivalAirport=" + arrivalAirport + ", arrivalDate=" + arrivalDate
				+ ", arrivalTime=" + arrivalTime + "]";
	}


	public SimpleStringProperty getTicketid() {
		return ticketid;
	}


	public void setTicketid(SimpleStringProperty ticketid) {
		this.ticketid = ticketid;
	}


	public SimpleStringProperty getUserid() {
		return userid;
	}


	public void setUserid(SimpleStringProperty userid) {
		this.userid = userid;
	}


	public void setFlightid(SimpleStringProperty flightid) {
		this.flightid = flightid;
	}


	public void setDepartAirport(SimpleStringProperty departAirport) {
		this.departAirport = departAirport;
	}


	public void setDepartDate(SimpleStringProperty departDate) {
		this.departDate = departDate;
	}


	public void setDepartTime(SimpleStringProperty departTime) {
		this.departTime = departTime;
	}


	public void setArrivalAirport(SimpleStringProperty arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}


	public void setArrivalDate(SimpleStringProperty arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public void setArrivalTime(SimpleStringProperty arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	//resolve comparable
//	public int compareTo(Flight f) {
//		
//		if (flightid == f.flightid) {
//			return 0;
//		} else {
//			return -1;
//		}	
//	}
}














////call the gui - create flight object - insert in db
//public static void createFlight(String depAirport, String depDate, String depTime, String arrAirport, String arrDate, String arrTime) {
//
//	int id = genFlightid();
//	Flight flight = new Flight(depAirport, depDate, depTime, arrAirport, arrDate, arrTime);
//	Insert.insertFlight(flight);
//	
//	if (Insert.successful) {
//		System.out.println("New Flight Created - Flight ID: " + id);
//	} else {
//		System.out.println("Failed");
//	}
//	
//}

////generate flightid num
//public static int genFlightid() {
//	
//	Random random = new Random();
//	int flightID = random.nextInt(999);
//	return flightID;
//}

























//public class Flight implements Comparable<Flight> {
//
//	private int flightid;
//	private String departAirport;
//	private String departDate;
//	private String departTime;
//	private String arrivalAirport;
//	private String arrivalDate;
//	private String arrivalTime;
//
//	public Flight() {
//	}
//	
//	public Flight(int flightid, String departAirport, String departDate, String departTime, String arrivalAirport, String arrivalDate, String arrivalTime) {
//		
//		this.flightid = flightid;
//		this.departAirport = departAirport;
//		this.departDate = departDate;
//		this.departTime = departTime;
//		this.arrivalAirport = arrivalAirport;
//		this.arrivalDate = arrivalDate;
//		this.arrivalTime = arrivalTime;
//	}
//	
//	
//	
//	public Flight(String departAirport, String departDate, String departTime, String arrivalAirport, String arrivalDate, String arrivalTime) {
//		
//		this.departAirport = departAirport;
//		this.departDate = departDate;
//		this.departTime = departTime;
//		this.arrivalAirport = arrivalAirport;
//		this.arrivalDate = arrivalDate;
//		this.arrivalTime = arrivalTime;
//	}
//	
//	
//	
//	
////	//call the gui - create flight object - insert in db
////	public static void createFlight(String depAirport, String depDate, String depTime, String arrAirport, String arrDate, String arrTime) {
////	
////		int id = genFlightid();
////		Flight flight = new Flight(id, depAirport, depDate, depTime, arrAirport, arrDate, arrTime);
////		Insert.insertFlight(flight);
////		
////		if (Insert.successful) {
////			System.out.println("New Flight Created - Flight ID: " + id);
////		} else {
////			System.out.println("Failed");
////		}
////		
////	}
//	
//	//generate flightid num
//	public static int genFlightid() {
//		
//		Random random = new Random();
//		int flightID = random.nextInt(999);
//		return flightID;
//	}
//
//	
//	//getter/setters
//	public int getFlightid() {
//		return flightid;
//	}
//
//	public void setFlightid(int flightid) {
//		this.flightid = flightid;
//	}
//
//	public String getDepartAirport() {
//		return departAirport;
//	}
//
//	public void setDepartAirport(String departAirport) {
//		this.departAirport = departAirport;
//	}
//
//	public String getDepartDate() {
//		return departDate;
//	}
//
//	public void setDepartDate(String departDate) {
//		this.departDate = departDate;
//	}
//
//	public String getDepartTime() {
//		return departTime;
//	}
//
//	public void setDepartTime(String departTime) {
//		this.departTime = departTime;
//	}
//
//	public String getArrivalAirport() {
//		return arrivalAirport;
//	}
//
//	public void setArrivalAirport(String arrivalAirport) {
//		this.arrivalAirport = arrivalAirport;
//	}
//
//	public String getArrivalDate() {
//		return arrivalDate;
//	}
//
//	public void setArrivalDate(String arrivalDate) {
//		this.arrivalDate = arrivalDate;
//	}
//
//	public String getArrivalTime() {
//		return arrivalTime;
//	}
//
//	public void setArrivalTime(String arrivalTime) {
//		this.arrivalTime = arrivalTime;
//	}
//
//	//create toStrings
//	@Override
//	public String toString() {
//		return "Flight [flightid=" + flightid + ", departAirport=" + departAirport + ", departDate=" + departDate
//				+ ", departTime=" + departTime + ", arrivalAirport=" + arrivalAirport + ", arrivalDate=" + arrivalDate
//				+ ", arrivalTime=" + arrivalTime + "]";
//	}
//	
//	
//	//resolve comparable
//	public int compareTo(Flight f) {
//		
//		if (flightid == f.flightid) {
//			return 0;
//		} else {
//			return -1;
//		}	
//	}
//}





























