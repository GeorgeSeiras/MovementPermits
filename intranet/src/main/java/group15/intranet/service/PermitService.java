package group15.intranet.service;

import java.util.List;
import java.util.Map;

import group15.intranet.entity.Permit;

public interface PermitService {
	
	List<Permit> getPermits(Map<String, String> searchParams);
	
	Permit getPermitById(int id);

	void deleteById(int id);
	
	void addPermit(Permit p);

	void updatePermitStatus(int id, String status);

}
