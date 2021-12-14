package businessLogic;

import java.util.ArrayList;
import java.util.Random;
import database.Insert;

public class User implements Comparable<User> {

	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String state;
	private int zipcode;
	private String email;
	private int ssn;
	private String securityquestion;
	private String securityanswer;
	//public static boolean is_Admin = false;

	
	public User() {
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// create user object
	
	public User(int userid, String username, String password, String firstname, String lastname, String address, String state, String email, int zipcode, int ssn, String securityquestion, String securityanswer) {
		
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.state = state;
		this.zipcode = zipcode;
		this.ssn = ssn;
		this.securityquestion = securityquestion;
		this.securityanswer = securityanswer;
	}
	
	
	//call Registration page to createUser
	public static void createUser(String username, String password, String firstname, String lastname, String address, String state, String email, int zipcode, int ssn, String securityquestion, String securityanswer) {
		
		int id = generateUserid();
		User user = new User(id, username, password, firstname, lastname, address, state, email, zipcode, ssn, securityquestion, securityanswer);
		Insert input = new Insert();
		input.insertUser(user);
	}
	
	public int getUserid() {
		return userid;
	}
	
	//generate user id from random num
	public static int generateUserid() {
		Random random = new Random();
		int idNum = random.nextInt(9999);
		return idNum;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getSecurityquestion() {
		return securityquestion;
	}

	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}

	public String getSecurityanswer() {
		return securityanswer;
	}

	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", address=" + address + ", state=" + state + ", zipcode="
				+ zipcode + ", email=" + email + ", ssn=" + ssn + ", securityquestion=" + securityquestion
				+ ", securityanswer=" + securityanswer + "]";
	}
	
	
//	public String toString() {
//		return getUserid() + this.getUsername() + this.getPassword() + this.getFirstname() + this.getLastname();
//	}
	
	
	
	public int compareTo(User u) {
		
		if (password == u.getPassword()) {
			return 0;
		} else
			return -1;
	}
}








