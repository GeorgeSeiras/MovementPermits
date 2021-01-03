package group15.intranet.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Permit;
import group15.intranet.model_request.PermitStatistics;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.repository.PermitRepository;
import group15.intranet.specification.PermitSpecification;

@Service
public class PermitServiceImpl implements PermitService {

	@Autowired
	PermitRepository permitRepository;

	@Override
	public ResponseEntity<Permit> getPermitById(int id) {
		Permit checkedPermit = permitRepository.findById(id);
		if(checkedPermit == null) {
			return new ResponseEntity<Permit>(checkedPermit,HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<Permit>(checkedPermit,HttpStatus.OK); 
	}

	@Override
	public List<Permit> getPermits(Map<String, String> searchParams) {
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
			
			list.add(new SearchCriteria("endDate", sqlDate, SearchOperation.EQUAL));
		}
		if (searchParams.containsKey("status")) {
			list.add(new SearchCriteria("status", searchParams.get("status"), SearchOperation.EQUAL));
		}
		return permitRepository.findAll(PermitSpecification.buildQuery(list));
	}
	
	@Override
	public void deleteById(int id) {
		
		permitRepository.deleteById(id);
		
	}

	@Override
	public ResponseEntity<Permit> addPermit(Permit permit) {
		permitRepository.save(permit);
		return new ResponseEntity<Permit>(permit,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Permit> updatePermit(int id, UpdatePermitDetailsRequestModel permitDetails) {
		Permit checkedPermit = permitRepository.findById(id);
		if(checkedPermit==null) {
			return new ResponseEntity<Permit>(checkedPermit,HttpStatus.NOT_FOUND);
		}else {
			checkedPermit.setStatus(permitDetails.getStatus());
			permitRepository.save(checkedPermit);
			System.out.println(checkedPermit.getStatus());
			return new ResponseEntity<Permit>(checkedPermit, HttpStatus.OK);
		}
	}

	@Override
	public PermitStatistics getStatistics() {
		int totalPermits = permitRepository.findAll().size();
		int validPermits = permitRepository.findByStatus("valid").size();
		int invalidPermits = permitRepository.findByStatus("invalid").size();
		int activePermits = permitRepository.findActive(new Date(System.currentTimeMillis())).size();
		int inactivePermits = permitRepository.findInactive(new Date(System.currentTimeMillis())).size();
		int dailyPermits = permitRepository.findByType("daily").size();
		int weeklyPermits = permitRepository.findByType("weekly").size();
		int monthlyPermits = permitRepository.findByType("monthly").size();
		return new PermitStatistics(totalPermits,validPermits,invalidPermits,activePermits,inactivePermits,dailyPermits,weeklyPermits,monthlyPermits);
	}

}
