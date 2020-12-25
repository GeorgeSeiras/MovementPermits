package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Permit;
import group15.intranet.repository.PermitRepository;
import group15.intranet.specification.PermitSpecification;

@Service
public class PermitServiceImpl implements PermitService {

	@Autowired
	PermitRepository permitRepository;



	@Override
	public Permit getPermitById(int id) {
		return permitRepository.findById(id);
	}

	@Override
	public List<Permit> getPermits(Map<String, String> searchParams) {
		// GenericSpecification<Permit> spec = new GenericSpecification<Permit>();
		List<SearchCriteria> list = new ArrayList<>();
		;
		if (searchParams.containsKey("id")) {
			list.add(new SearchCriteria("permit_id", searchParams.get("id"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("fname")) {
			list.add(new SearchCriteria("fname", searchParams.get("fname"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("lname")) {
			list.add(new SearchCriteria("lname", searchParams.get("lname"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("start_date")) {
			list.add(new SearchCriteria("start_date", searchParams.get("start_date"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("end_date")) {
			list.add(new SearchCriteria("end_date", searchParams.get("end_date"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("status")) {
			list.add(new SearchCriteria("status", searchParams.get("status"), SearchOperation.EQUAL));
		}
		return permitRepository.findAll(PermitSpecification.buildQuery(list));
	}

}
