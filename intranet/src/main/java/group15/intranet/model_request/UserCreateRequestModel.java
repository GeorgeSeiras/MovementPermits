package group15.intranet.model_request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class UserCreateRequestModel {
	private int userID;
	@NotNull
	private String fname;
	@NotNull
	private String lname;
	@NotNull
	private String address;
	@NotNull
	private String phoneNum;
	@NotNull
	private String department;
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	private List<String> authorities;
	
	
	
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String dep) {
		this.department = dep;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
}
