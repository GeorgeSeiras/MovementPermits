package group15.intranet.model_request;

import javax.validation.constraints.NotNull;

public class RolesDetailsModelRequest {

	@NotNull
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
