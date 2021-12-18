package businessLogic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import database.DBQueries;

public class Booking {

	
	private String ticketid;
	private String userid;
	private String flightid;
	private String depairport;
	private String depdate;
	private String deptime;
	private String arrairport;
	private String arrdate;
	private String arrtime;
	
	public Booking() {
	}
	
	
	public Booking(String ticketid, String userid, String flightid, String depairport, String depdate, String deptime, String arrairport, String arrdate, String arrtime) {
		this.ticketid = ticketid;
		this.userid = userid;
		this.flightid = flightid;
		this.depairport = depairport;
		this.depdate = depdate;
		this.deptime = deptime;
		this.arrairport = arrairport;
		this.arrdate = arrdate;
		this.arrtime = arrtime;	
	}
	
	
	public Booking(String flightid) {
		this.flightid = flightid;
	}
	
	

	
//	public Booking(int ticketid, int userid, int flightid) {
//		this.ticketid = ticketid;
//		this.userid = userid;
//		this.flightid = flightid;
	
	
	
	
	public Booking(String ticketid, String userid, String flightid) {
		this.ticketid = ticketid;
		this.userid = userid;
		this.flightid = flightid;
	}
	
//	public void bookFlight(String flightid) {
//		//int ticketnum = genTicketID();
//		Flight booker = DBQueries.obtainFlight(flightid);
//		Booking booking = new Booking(ticketid, userid, flightid);
//		DBQueries.insertBooking(booking);
//	}
	
//	public static int genTicketID() {
//		Random random = new Random();
//		int ticknum = random.nextInt(999);
//		return ticknum;
//	}


	public String getTicketid() {
		return ticketid;
	}


	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getFlightid() {
		return flightid;
	}


	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}


	public String getDepairport() {
		return depairport;
	}


	public void setDepairport(String depairport) {
		this.depairport = depairport;
	}


	public String getDepdate() {
		return depdate;
	}


	public void setDepdate(String depdate) {
		this.depdate = depdate;
	}


	public String getDeptime() {
		return deptime;
	}


	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}


	public String getArrairport() {
		return arrairport;
	}


	public void setArrairport(String arrairport) {
		this.arrairport = arrairport;
	}


	public String getArrdate() {
		return arrdate;
	}


	public void setArrdate(String arrdate) {
		this.arrdate = arrdate;
	}


	public String getArrtime() {
		return arrtime;
	}


	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	
	
	
}
	

	
	





