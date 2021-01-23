package group15.intranet.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Permit;
import group15.intranet.model_request.PermitStatistics;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;

public interface PermitService {
	
	List<Permit> getPermits(Map<String, String> searchParams);
	
	ResponseEntity<Permit> getPermitById(int id);
	
	ResponseEntity<List<Permit>> getSupervisorPermits(int supervisorId);

	void deleteById(int id);
	
	ResponseEntity<Permit> addPermit(Permit p);


	ResponseEntity<Permit> updatePermit(int id, UpdatePermitDetailsRequestModel permitDetails);
	
	PermitStatistics getStatistics();
	
	ResponseEntity<List<Permit>> getUserPermits(int userId);
}
