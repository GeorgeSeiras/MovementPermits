package group15.intranet.model_request;

import javax.validation.constraints.NotNull;

import group15.intranet.entity.Department;

public class UpdateUserDetailsRequestModel {

	@NotNull
	private String fname;
	private String lname;
	@NotNull(message="address cant be null")
	private String address;
	@NotNull
	private String phoneNum;
	@NotNull
	private Department dep;

	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
}
