package group15.intranet.model_request;

import javax.validation.constraints.NotNull;

public class UpdatePermitDetailsRequestModel {

	@NotNull(message="Status cant be null")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
