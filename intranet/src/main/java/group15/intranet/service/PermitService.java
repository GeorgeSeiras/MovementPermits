package group15.intranet.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Permit;
import group15.intranet.model_request.CreatePermitRequestModel;
import group15.intranet.model_request.PermitStatistics;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;

public interface PermitService {
	
	List<Permit> getPermits(Map<String, String> searchParams) throws ParseException;
	
	ResponseEntity<Permit> getPermitById(int permitID, int userID);
	
	ResponseEntity<List<Permit>> getSupervisorPermits(int supervisorId);

	void deleteById(int id);
	
	ResponseEntity<Permit> addPermit(CreatePermitRequestModel permitCreateModel);


	ResponseEntity<Permit> updatePermit(int id, UpdatePermitDetailsRequestModel permitDetails);
	
	PermitStatistics getStatistics();
	
	ResponseEntity<List<Permit>> getUserPermits(int userId);
}
