package group15.intranet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Permit;
import group15.intranet.repository.PermitRepository;

@Service
public class PermitService {
	
	@Autowired
	private PermitRepository permitRepository;

	
	public List<Permit> getAllPermits() {
		return permitRepository.findAll();
	}

	
	public List<Permit> getPermits(int id, int status, Date startDate, String type, String address) {
		Permit example = Permit.builder()
				.permitID(id)
				.build();
		return permitRepository.findAll(Example.of(example));
	}

}
