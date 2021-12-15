package businessLogic;

import java.util.Random;

import database.Insert; 

public class Flight implements Comparable<Flight> {

	private int flightid;
	private String departAirport;
	private String departDate;
	private String departTime;
	private String arrivalAirport;
	private String arrivalDate;
	private String arrivalTime;

	public Flight() {
	}
	
	public Flight(int flightid, String departAirport, String departDate, String departTime, String arrivalAirport, String arrivalDate, String arrivalTime) {
		
		this.flightid = flightid;
		this.departAirport = departAirport;
		this.departDate = departDate;
		this.departTime = departTime;
		this.arrivalAirport = arrivalAirport;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}
	
	
//	//call the gui - create flight object - insert in db
//	public static void createFlight(String depAirport, String depDate, String depTime, String arrAirport, String arrDate, String arrTime) {
//	
//		int id = genFlightid();
//		Flight flight = new Flight(id, depAirport, depDate, depTime, arrAirport, arrDate, arrTime);
//		Insert.insertFlight(flight);
//		
//		if (Insert.successful) {
//			System.out.println("New Flight Created - Flight ID: " + id);
//		} else {
//			System.out.println("Failed");
//		}
//		
//	}
	
	//generate flightid num
	public static int genFlightid() {
		
		Random random = new Random();
		int flightID = random.nextInt(999);
		return flightID;
	}

	
	//getter/setters
	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public String getDepartAirport() {
		return departAirport;
	}

	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	//create toStrings
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", departAirport=" + departAirport + ", departDate=" + departDate
				+ ", departTime=" + departTime + ", arrivalAirport=" + arrivalAirport + ", arrivalDate=" + arrivalDate
				+ ", arrivalTime=" + arrivalTime + "]";
	}
	
	
	//resolve comparable
	public int compareTo(Flight f) {
		
		if (flightid == f.flightid) {
			return 0;
		} else {
			return -1;
		}	
	}
}





























