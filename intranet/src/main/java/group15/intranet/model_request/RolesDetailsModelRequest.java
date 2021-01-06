package group15.intranet.model_request;

import javax.validation.constraints.NotNull;

public class RolesDetailsModelRequest {

	@NotNull
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
