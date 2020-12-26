package group15.intranet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			list.add(new SearchCriteria("permitID", searchParams.get("id"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("fname")) {
			list.add(new SearchCriteria("fname", searchParams.get("fname"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("lname")) {
			list.add(new SearchCriteria("lname", searchParams.get("lname"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("start_date")) {
			java.util.Date utilDate = null;
			java.sql.Date sqlDate = null;

			try {

				utilDate = new SimpleDateFormat("yyy-MM-dd").parse(searchParams.get("start_date"));
				sqlDate = new java.sql.Date(utilDate.getTime());

			} catch (ParseException e) {}

			list.add(new SearchCriteria("startDate", sqlDate, SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("end_date")) {
			java.util.Date utilDate = null;
			java.sql.Date sqlDate = null;

			try {

				utilDate = new SimpleDateFormat("yyy-MM-dd").parse(searchParams.get("end_date"));
				sqlDate = new java.sql.Date(utilDate.getTime());

			} catch (ParseException e) {}
			
			list.add(new SearchCriteria("endDate", searchParams.get("end_date"), SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("status")) {
			list.add(new SearchCriteria("status", searchParams.get("status"), SearchOperation.EQUAL));
		}
		return permitRepository.findAll(PermitSpecification.buildQuery(list));
	}

}
