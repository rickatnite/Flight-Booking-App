package database;

import java.sql.*;
import java.util.ArrayList;

import businessLogic.Booking;
import businessLogic.Flight;
import businessLogic.User;

public class Insert {

	static final String dbURL = "jdbc:postgresql://localhost:5432/";
	static final String dbUser = "ric";
	static final String dbPass = null;
	
	public static Boolean successful;
	public ArrayList<Object> resultList;
	
	//insert new flight to db
	public static void insertFlight(Flight flight) {
		
		successful = false;
		Connection connection = null;
		try {
			System.out.println("Database Connected Successfully!");
			
			connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String query = "INSERT INTO flight(flight attributes here)";
					
			PreparedStatement psFlight = connection.prepareStatement(query);
			
			psFlight.setInt(1, flight.getFlightid());
			//...
			//...
			//...
				
			psFlight.executeUpdate();
			
			connection.close();
				successful = true;
		} catch (Exception e) {
			System.out.println("Database error");
			e.printStackTrace();
			successful = false;
		}
	}
	
	//insert new booking method
	public static void insertBooking(Booking booking) {
		successful = false;
		try {
			System.out.println("Database Connected Successfully!");
			
			Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String query = "query here";
			String query2 = "";
			
			PreparedStatement psBooking = connection.prepareStatement(query);
			
			psBooking.setInt(1, booking.getTicketid());
			//...
			//...
			//...
			
			psBooking.executeUpdate();		
			connection.close();
			successful = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			successful = false;
		}
			//add any other needed exceptions here
		
	}
	
	
	//insert new user method
	public void insertUser(User user) {
		successful = false;
		try {
			System.out.println("Database Connected Successfully!");
			
			Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String query = "query here";
			
			PreparedStatement psUser = connection.prepareStatement(query);
			
			psUser.setInt(1, user.getUserid());
			psUser.setString(2, user.getUsername());
			psUser.setString(3, user.getPassword());
			psUser.setString(4, user.getFirstname());
			psUser.setString(5, user.getLastname());
			psUser.setString(6, user.getAddress());
			psUser.setString(7, user.getState());
			psUser.setInt(8, user.getZipcode());
			psUser.setString(9, user.getEmail());
			psUser.setInt(10, user.getSsn());
			psUser.setString(11, user.getSecurityquestion());
			psUser.setString(12, user.getSecurityanswer());
			
			psUser.executeUpdate();
			
			connection.close();
			successful = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			successful = false;
			//add any other needed exceptions here
		}
	}
}






























