package Model;

import java.io.Serializable;

public abstract class User implements Serializable{

	private String userName;
	private String password;
	
	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
	public User() {

	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
			this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
