package group15.intranet.model_request;

import group15.intranet.entity.Permit;

public class CreatePermitRequestModel {

	Permit permit;
	
	int userID;

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
