package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import businessLogic.User;
import database.DBQueries;
import database.LoginDB;
import database.Queries;
import database.VO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
    private TextField addressTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField secPassTF;
    @FXML
    private TextField secQuesTF;
    @FXML
    private TextField ssnTF;
    @FXML
    private TextField stateTF;
    @FXML
    private TextField zipcodeTF;
	@FXML
	private TextField firstNameTF;
	@FXML
	private TextField lastNameTF;
	@FXML
	private Label wrongLogIn;
	@FXML
	private Label wrongInput;
	@FXML
	private Label wrongInput2;
	@FXML
	private Label SecurityQuestionRetrieved;
	@FXML
	private TextField usernameTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Button loginButton;
	@FXML
	private Button registerButton;
	@FXML
	private Button recoverPasswordButton;
	@FXML
	private Button returnToLoginButton;
	@FXML
	private Button submitToLoginButton;
	@FXML
	private Button submitToGetQuestion;
	@FXML
	private Button submitToGetPass;
	


	
	//Method to go to Login Page
	public void switchToScene1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//Method to go to Registration page
	public void switchToScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//Method to go to Forgot Password page
	public void switchToScene3(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	//Method to go to Account Page
	public void switchToScene4(ActionEvent event) throws IOException {
		User user = new User();
		String username = usernameTF.getText().toString();
		String password = passwordTF.getText().toString();
		
		
		try {
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
	    	
	    		String userid = rsUserID.getString(1);
	    		user.setUserid(userid);
	    		System.out.println("User ID: " + userid);
	    		
	    		
	    	} while (rsUserID.next());
	    }
	    
	     //Close the connection
	    connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		user.setUsername(username);
		user.setPassword(password);
		
		
		VO vo = new VO();
		vo.setUser(user);
	
		
		
		try {
			DBQueries.login(VO.getUser());
			
			Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usernameTF.getText().isEmpty() && passwordTF.getText().isEmpty()) {
			wrongLogIn.setText("Please enter your data.");
		}
		
		else {
			wrongLogIn.setText("Wrong username or password!");
		}
		
		
	}
	
	//Method to get SecurityQuestion
	public void SecurityQuestionGet(ActionEvent event) throws IOException {
		User user = new User();
		
		String username = usernameTF.getText().toString();
		
		user.setUsername(username);
		
		try {
			
			DBQueries.getSecurityQuestion(user);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wrongInput.setText(user.getSecurityquestion());
		
		
//		if(secPassTF.getText().toString().equals("javacoding")) {
//			wrongInput2.setText("Success!");
//		}
//		else {
//			wrongInput2.setText("Incorrect Password");
//		}
		
	}
	//Method to retrieve password
//	public void getPassword(ActionEvent event) throws IOException {
//
//		
//		if(secPassTF.getText().toString().equals("javacoding")) {
//			wrongInput2.setText("Success!");
//		}
//		else {
//			wrongInput2.setText("Incorrect Password");
//		}
		
//		//Retrieve Password using Security Answer
		
		//wrongInput.setText(user.getSecurityquestion());
//		String securityAnswer = secPassTF.getText().toString();
//		user.setSecurityanswer(securityAnswer);
//		
//		
//		try {
//			DBQueries.retrievePass(user);
//			//LoginDB.obtainPassword(user, securityAnswer);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//wrongInput2.setText(user.getPassword());
		
	//}
	
	
	
//	String uname = usernameInput.getText();
//	String secA = SecurityAnswerInput.getText();
//	
//	
//	try {
//		
//		LoginDB check = new LoginDB();
//		
//		String display = check.obtainPassword(uname, secA);
//		
//		System.out.println(display);
//			
//	} catch(Exception ex) {
//		ex.printStackTrace();
//	}
	
	
	
	
	
	public void switchToScene1Register(ActionEvent event) throws IOException {
		User user = new User();
		String username = usernameTF.getText().toString();
		String password = passwordTF.getText().toString();
		String firstName = firstNameTF.getText().toString();
		String lastName = lastNameTF.getText().toString();
		String address = addressTF.getText().toString();
		String zipcode = zipcodeTF.getText().toString();
		String state = stateTF.getText().toString();
		String email = emailTF.getText().toString();
		String ssn = ssnTF.getText().toString();
		String securityQuestion = secQuesTF.getText().toString();
		String securityAnswer = secPassTF.getText().toString();
		
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setAddress(address);
		user.setZipcode(zipcode);
		user.setState(state);
		user.setEmail(email);
		user.setSsn(ssn);
		user.setSecurityquestion(securityQuestion);
		user.setSecurityanswer(securityAnswer);
		
		
		try {
			DBQueries.insertNewUser(user);
			
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
		
		
//		//Validate user and pass
//		if(username.equals("javacoding") && password.equals("123")) {
//			wrongLogIn.setText("Success!");
		

			
		//retunr obvseravbleList of flights	
			
			
			
			

	}
	//Method to call check login
//	public void userLogIn(ActionEvent event) throws IOException {
//		checkLogin();
//	}
	//Method to check login
//	private void checkLogin() throws IOException {
//		Main m = new Main();
//		if(usernameTF.getText().toString().equals("javacoding") && passwordTF.getText().toString().equals("123")) {
//			wrongLogIn.setText("Success!");
//			
//			m.changeScene("Scene4.fxml");
//		}
//		
//		else if(usernameTF.getText().isEmpty() && passwordTF.getText().isEmpty()) {
//			wrongLogIn.setText("Please enter your data.");
//		}
//		
//		else {
//			wrongLogIn.setText("Wrong username or password!");
//		}
//	}

