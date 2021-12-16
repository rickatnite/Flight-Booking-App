
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import businessLogic.Flight;
import businessLogic.User;
import businessLogic.Booking;

//import edu.gsu.common.Action;
//import edu.gsu.common.Customer;
//import edu.gsu.common.Flight;
//import edu.gsu.exceptions.LoginException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBQueries {
	

	
	//login db query - works
	public static void login(User u) throws Exception {
			
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection
					      ("jdbc:postgresql://localhost:5432/", "ric", null);
					       // ("jdbc:mysql://104.196.113.68/test","root","password");
					
			System.out.println("Database connected");
			
			PreparedStatement statement = connection.prepareStatement(Queries.LOGIN);
			// Create a statement
			//PreparedStatement statement = connection.prepareStatement(Action.LOGIN);
				    
			statement.setString(1, u.getUsername());
			statement.setString(2, u.getPassword());
				    
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			
//			int count = 0;
//
//			// Iterate through the result and print the student names
//			while (resultSet.next()) {
//				System.out.println("Number of Users:" + resultSet.getInt(1));
//				count = resultSet.getInt(1);
//			}
//			
//			if (count == 0)
			if (!resultSet.next()) {
				throw new Exception("Invalid UserName or Password!");
			}
				     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			
			connection.close();
		}
	}    
	
	
	public static void main(String[] args) throws Exception {
		
		User c0 = new User();
		login(c0);
		
		
	}
	
	
	// insertNewUser db query - works
	public static void insertNewUser(User u) throws SQLException {
		   
		
		String user = u.getUsername();
		String pass = u.getPassword();
		String first = u.getFirstname();
		String last = u.getLastname();
		String addy = u.getAddress();
		String zip = u.getZipcode();
		String state = u.getState();
		String email = u.getEmail();
		String social = u.getSsn();
		String secQues = u.getSecurityquestion();
		String secAnsw = u.getSecurityanswer();

	    // Step 1: Establishing a Connection
	    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null)) {
	    	            System.out.println("Connected to PostgreSQL database!");
	    		
	        // Step 2: Create a statement using connection object
	        PreparedStatement psInsertNewUser = connection.prepareStatement(Queries.INSERT_NEW_USER); 
	        
	// first arg number corresponds to column index from VALUES (?,?,?,?) and sets the data field in table to string in second arg
	        psInsertNewUser.setString(1, user);
	        psInsertNewUser.setString(2, pass);
	        psInsertNewUser.setString(3, first);
	        psInsertNewUser.setString(4, last);
	        psInsertNewUser.setString(5, addy);
	        psInsertNewUser.setString(6, zip);
	        psInsertNewUser.setString(7, state);
	        psInsertNewUser.setString(8, email);
	        psInsertNewUser.setString(9, social);
	        psInsertNewUser.setString(10, secQues);
	        psInsertNewUser.setString(11, secAnsw);
	        
	        // how do we get these strings from the textfield/login box entry? 
	        System.out.println(psInsertNewUser);
	        
	        // Step 3: Execute the query or update query
	        psInsertNewUser.executeUpdate();

	        //use instead to work with result set:
	        //ResultSet rsInsertNewUser = psInsertNewUser.executeQuery();
	            
	    } catch (SQLException e) {

	        // print SQL exception information
	        printSQLException(e);
	    }

	    //try with resource - exception
	}
	
	public static void printSQLException(SQLException ex) {
	    for (Throwable e: ex) {
	        if (e instanceof SQLException) {
	            e.printStackTrace(System.err);
	            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	            System.err.println("Message: " + e.getMessage());
	            Throwable t = ex.getCause();
	            while (t != null) {
	                System.out.println("Cause: " + t);
	                t = t.getCause();
	            }
	        }
	    }
	}

	
	
	
	//Returns an ObservableList of all Flights from the database
		public static ObservableList<Flight> flightList() {
			
			 ObservableList<Flight> flights = FXCollections.observableArrayList();

			try {

				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);

				PreparedStatement psGetFlights = connection.prepareStatement(Queries.GET_FLIGHTS);

				ResultSet rsAllFlights = psGetFlights.executeQuery();

				while (rsAllFlights.next()) {
					
					flights.add(new Flight(rsAllFlights.getString("flightid"), rsAllFlights.getString("departureairport"), 
							rsAllFlights.getString("departuredate"), rsAllFlights.getString("departuretime"), rsAllFlights.getString("arrivalairport"), 
							rsAllFlights.getString("arrivaldate"), rsAllFlights.getString("arrivaltime")));
					
				}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flights;
		}
					
		
		
		
		//return flights;
//		Flight flight = new Flight();
//
//		flight.setFlightid(rsAllFlights.getString("flightid"));
//		flight.setDepartAirport(rsAllFlights.getString("departureairport"));
//		flight.setDepartDate(rsAllFlights.getString("departuredate"));
//		flight.setDepartTime(rsAllFlights.getString("departuretime"));
//		flight.setArrivalAirport(rsAllFlights.getString("arrivalairport"));
//		flight.setArrivalDate(rsAllFlights.getString("arrivaldate"));
//		flight.setArrivalTime(rsAllFlights.getString("arrivaltime"));
//
//		flights.addAll(flight);
//		//flights.add(flight);
		
//					//this is only printing the column in getString - how to get all columns as list
//					String id = rsAllFlights.getString(1);
//					String depcode = rsAllFlights.getString(2);
//					String depdate = rsAllFlights.getString(3);
//					String deptime = rsAllFlights.getString(4);
//					String arrcode = rsAllFlights.getString(5);
//					String arrdate = rsAllFlights.getString(6);
//					String arrtime = rsAllFlights.getString(7);
//				
//					//List<String> allFlightsList = new ArrayList<String>();
//					//String displayFlights = String.join("", allFlightsList);
//					//System.out.println(displayFlights);
//					
//					ArrayList<String> theList = new ArrayList<String>();
//					theList.add(id);
//					theList.add(depcode);
//					theList.add(depdate);
//					theList.add(deptime);
//					theList.add(arrcode);
//					theList.add(arrdate);
//					theList.add(arrtime);
//					
//					//System.out.println(Arrays.toString(flights.toArray()));
//					
//					//System.out.println(id + " " + depcode + " " + depdate + " " + deptime + " " + arrcode + " " + arrdate + " " + arrtime);
//					
//					//how to get these Strings into list so i can display it ????
//					
//					//String x = " ";
//					
//					for(int i = 0; i < theList.size(); i++){
//					    System.out.println(theList.get(i));
//					    //x += theList.get(i);
//					      
//					}
//					
//					//return x;
					
					
					



//WORKS
//GET_USERID = "SELECT userid FROM public.user WHERE username = ? AND password = ?";
	
public static void getUserID(User u) throws SQLException, ClassNotFoundException {

		  String username = u.getUsername();
		  String password = u.getPassword();
		  
	    // Connect to a database
	    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
	    System.out.println("Database connected");

	    // Create a statement
	    PreparedStatement psGetUserID = connection.prepareStatement(Queries.GET_USERID);

	    psGetUserID.setString(1, username);
        psGetUserID.setString(2, password);
	    
	    // Execute a statement
	    ResultSet rsUserID = psGetUserID.executeQuery();
	    

	    if (rsUserID.next()) {
	    	do {
	    	
	    		int userid = rsUserID.getInt(1);
	    		System.out.println("User ID: " + userid);
	    		
	    	} while (rsUserID.next());
	    }
	    
	     //Close the connection
	    connection.close();
	  }
	  
	 
	  
public static void getSecurityQuestion(User u) throws SQLException, ClassNotFoundException {

	  String username = u.getUsername();
	  //String password = u.getPassword();
	  
  // Connect to a database
  Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
  System.out.println("Database connected");

  // Create a statement
  PreparedStatement psSecurityQuestion = connection.prepareStatement(Queries.GET_SECURITYQUESTION);

  psSecurityQuestion.setString(1, username);
  //psSecurityQuestion.setString(2, password);
  
  // Execute a statement
  ResultSet rsSecurityQuestion = psSecurityQuestion.executeQuery();
  
  
  if (rsSecurityQuestion.next()) {
  	do {
  		
  		String secquestion = rsSecurityQuestion.getString(1);
  		
  		u.setSecurityquestion(secquestion);
  		System.out.println("Security question: " + secquestion);
  		
  	} while (rsSecurityQuestion.next());
  }	  
	  
  connection.close();
}
 
	  

public static void retrievePass(User u) throws SQLException, ClassNotFoundException {

	  String username = u.getUsername();
	  String securityanswer = u.getSecurityanswer();
	  
	// Connect to a database
	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
	System.out.println("Database connected");
	
	// Create a statement
	PreparedStatement psPass = connection.prepareStatement(Queries.GET_PASSWORD);
	
	psPass.setString(1, username);
	psPass.setString(2, securityanswer);
	
	// Execute a statement
	ResultSet rsPass = psPass.executeQuery();
	
	
	System.out.println("here now");
	
	if (rsPass.next()) {
		do {
			
			String correctPass = rsPass.getString(1);
			
			u.setPassword(correctPass);
			System.out.println("Your password is: " + correctPass);
			
		} while (rsPass.next());
	}	  
		  
	connection.close();
	}



public static Flight obtainFlight(int flightid) {

	Flight flight = new Flight();
	try {

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);

		PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_FLIGHT);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			flight.setFlightid(rs.getString("flightid"));
			flight.setDepartAirport(rs.getString("depairport"));
			flight.setDepartDate(rs.getString("depdate"));
			flight.setDepartTime(rs.getString("deptime"));
			flight.setArrivalAirport(rs.getString("arrairport"));
			flight.setArrivalDate(rs.getString("arrdate"));
			flight.setArrivalTime(rs.getString("arrtime"));
		}

		connection.close();

	} catch (Exception e) {
		e.printStackTrace();

	}
	return flight;
	
}









public static ObservableList<Booking> retrieveBookings(int userid) {

	 ObservableList<Booking> bookings = FXCollections.observableArrayList();

	
	try {

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
        System.out.println("Connected to PostgreSQL database!");
        
		PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_BOOKED_TICKETS);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			
			Booking booked = new Booking(rs.getInt("ticketid"), (rs.getInt("flightid")), (rs.getInt("userid")));
				
			bookings.add(booked);

		}
		connection.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return bookings;
}






//Method to insert new booking in the database
public static void insertBooking(Booking booking){
	
	try {
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
            System.out.println("Connected to PostgreSQL database!");
		
		PreparedStatement preparedStatement = connection.prepareStatement(Queries.BOOK_TICKET);

		preparedStatement.setInt(1, booking.getTicketid());
		preparedStatement.setInt(2, booking.getFlightid());
		preparedStatement.setInt(3, booking.getUserid());

		preparedStatement.executeUpdate();

		connection.close();
		
		System.out.println("Ticket number is: " + booking.getTicketid());
		
		} catch(Exception e) {
			e.printStackTrace();
		}
}













}









