package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessLogic.User;

public class LoginDB {

	static final String dbURL = "jdbc:postgresql://localhost:5432/";
	static final String dbUser = "ric";
	static final String dbPass = null;
	public static Boolean successful;
	static Connection connection;
	
	public String login(String username) {
		String result = "";
		successful = false;

		try {
			
			System.out.println("Database Connected Successfully!");
			
			connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			
			PreparedStatement psLogin = connection.prepareStatement("query");
			
			ResultSet rsLogin = psLogin.executeQuery();
			
			if (rsLogin.next()) {
				
				result = rsLogin.getString("password");
			}
			
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Boolean obtainUsername(String username) {
		
		Boolean result = false;
		int checker = 0;
		try {
			connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			PreparedStatement psou = connection.prepareStatement("query");
			
			ResultSet rsou = psou.executeQuery();
			
			if (rsou.next()) {
				checker = rsou.getInt("username");
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (checker > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
		
	}
	
	
	
	
	public static String obtainPassword(User username, String securityanswer) {
		
		String result = "";
		String actualAnswer = "";
		String password = "";
		String givenAnswer = securityanswer;
		
		try {
			connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
			
			PreparedStatement psop = connection.prepareStatement(Queries.GET_PASSWORD);
			
			ResultSet rsop = psop.executeQuery();
			
			if (rsop.next()) {
				
				password = rsop.getString("password");
				actualAnswer = rsop.getString(givenAnswer);
				
				System.out.println("Your password is: " + password);
			}
			
			if (!givenAnswer.equals(actualAnswer)) {
				result = "Incorrect";
			} else if (givenAnswer.equals(actualAnswer)) {
				result = "Your password is: " + password;
			} else {
				result = "Username not found";
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}
	
}

























