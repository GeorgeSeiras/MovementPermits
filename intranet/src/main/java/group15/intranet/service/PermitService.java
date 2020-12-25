package group15.intranet.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import group15.intranet.entity.Permit;
import group15.intranet.repository.PermitRepository;

public interface PermitService {
	
	List<Permit> getPermits(Map<String, String> searchParams);
	
	Permit getPermitById(int id);

}
