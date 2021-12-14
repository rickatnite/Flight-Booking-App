package application;

import java.io.IOException;
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
	private Label wrongLogIn;
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
		
		//Validate user and pass
		if(usernameTF.getText().toString().equals("javacoding") && passwordTF.getText().toString().equals("123")) {
			wrongLogIn.setText("Success!");
		
			Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(usernameTF.getText().isEmpty() && passwordTF.getText().isEmpty()) {
			wrongLogIn.setText("Please enter your data.");
		}
		
		else {
			wrongLogIn.setText("Wrong username or password!");
		}
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
}
