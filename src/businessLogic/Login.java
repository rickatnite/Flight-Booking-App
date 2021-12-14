package businessLogic;

import database.LoginDB;

public class Login {

	private String username;
	private String password;
	private Boolean loginBool;
	
	public Login() {
	}
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
		this.loginBool = false;
	}
	
	public void checkpw(String checker) {
		if (this.getPassword().equals(checker)) {
			setLoginBool(true);
		} else {
			setLoginBool(false);
		}
	}
	
	
	public Boolean checklogin() {
		
		LoginDB logg = new LoginDB();
		String checker = logg.login(getUsername());
		checkpw(checker);
		return loginBool;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoginBool() {
		return loginBool;
	}

	public void setLoginBool(Boolean loginBool) {
		this.loginBool = loginBool;
	}
	
	
	
}

























