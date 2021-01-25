package group15.intranet.model_request;

import javax.validation.constraints.NotNull;

public class LogInRequestModel {

	@NotNull
	String username;
	@NotNull
	String password;
	
	
	
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
