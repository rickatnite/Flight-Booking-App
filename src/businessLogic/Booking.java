package businessLogic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseInterfaceLayer.LoginDBO;
import graphicUserInterface.AlertBox;

public class Booking {





	
	
	
	
	String uname = usernameInput.getText();
	String secA = SecurityAnswerInput.getText();
	
	
	try {
		
		LoginDBO check = new LoginDBO();
		
		String display = check.returnPassword(uname, secA);
		
		System.out.println(display);
			
	} catch(Exception ex) {
		ex.printStackTrace();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public String returnPassword(String email, String security_A) {
	
		String result = "";
		String correctAns = "";
		String pword = "";
		String userAns = security_A;
		
		try {
	
			connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
	
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM account WHERE email=" + "'" + email + "'");
	
			ResultSet res = preparedStatement.executeQuery();
	
			if (res.next()) {
				
				pword = res.getString("password");
				correctAns = res.getString("security_a");
				
				System.out.println(pword + correctAns);
				
			}
	
			if (!userAns.equals(correctAns)) {
				result = "Incorrect answer to security question";
			
	
			}else if (userAns.equals(correctAns)) {
				result = "Your password is: "  + pword; 
				
			}else {
				result = "I'm sorry we dont have an account with that email address";
				
				}
			
		
	
			connection.close();
	
		} catch (Exception ex) {
	
			ex.printStackTrace();
	
		}
		return result;
	
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

























