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
import org.springframework.transaction.annotation.Transactional;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Permit;
import group15.intranet.model_request.PermitStatistics;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.repository.PermitRepository;
import group15.intranet.repository.UserRepository;
import group15.intranet.specification.PermitSpecification;
import group15.intranet.specification.JoinPermitUserSpecification;

@Service
@Transactional
public class PermitServiceImpl implements PermitService {

	@Autowired
	PermitRepository permitRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<Permit> getPermitById(int id) {
		Permit checkedPermit = permitRepository.findById(id);
		if (checkedPermit == null) {
			return new ResponseEntity<Permit>(checkedPermit, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Permit>(checkedPermit, HttpStatus.OK);
	}

	@Override
	public List<Permit> getPermits(Map<String, String> searchParams) {
		List<SearchCriteria> list = new ArrayList<>();
		List<Permit> permits = new ArrayList<>();
		if (searchParams.containsKey("fname") && searchParams.containsKey("lname")) {
			permits = permitRepository.findAll(
					JoinPermitUserSpecification.buildQuery(searchParams.get("fname"), searchParams.get("lname")));
		} else {

			if (searchParams.containsKey("id")) {
				list.add(new SearchCriteria("permitID", searchParams.get("id"), SearchOperation.EQUAL));

			} else if (searchParams.containsKey("start_date")) {
				java.util.Date utilDate = null;
				java.sql.Date sqlDate = null;

				try {

					utilDate = new SimpleDateFormat("yyy-MM-dd").parse(searchParams.get("start_date"));
					sqlDate = new java.sql.Date(utilDate.getTime());

				} catch (ParseException e) {
				}

				list.add(new SearchCriteria("startDate", sqlDate, SearchOperation.EQUAL));
			} else if (searchParams.containsKey("end_date")) {
				java.util.Date utilDate = null;
				java.sql.Date sqlDate = null;

				try {

					utilDate = new SimpleDateFormat("yyy-MM-dd").parse(searchParams.get("end_date"));
					sqlDate = new java.sql.Date(utilDate.getTime());

				} catch (ParseException e) {
				}

				list.add(new SearchCriteria("endDate", sqlDate, SearchOperation.EQUAL));
			} else if (searchParams.containsKey("status")) {
				list.add(new SearchCriteria("status", searchParams.get("status"), SearchOperation.EQUAL));
			}
			permits = permitRepository.findAll(PermitSpecification.buildQuery(list));
		}
		if (searchParams.containsKey("userID")) {
			permits = permitRepository.findByUser_userID(Integer.parseInt(searchParams.get("userID")));
		}
		if (searchParams.containsKey("superId")) {
			List<Permit> finalPermits = new ArrayList<Permit>();
			for (Permit permit : permits) {
				if (permit.getUser().getDept().getDeptID() == Integer.parseInt(searchParams.get("superId"))) {
					finalPermits.add(permit);
				}
			}
			return finalPermits;
		} else {
			return permits;
		}

	}

	@Override
	public void deleteById(int id) {

		permitRepository.deleteById(id);

	}

	@Override
	public ResponseEntity<Permit> addPermit(Permit permit) {
		permitRepository.save(permit);
		return new ResponseEntity<Permit>(permit, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Permit> updatePermit(int id, UpdatePermitDetailsRequestModel permitDetails) {
		Permit checkedPermit = permitRepository.findById(id);
		if (checkedPermit == null) {
			return new ResponseEntity<Permit>(checkedPermit, HttpStatus.NOT_FOUND);
		} else {
			checkedPermit.setStatus(permitDetails.getStatus());
			return new ResponseEntity<Permit>(checkedPermit, HttpStatus.OK);
		}
	}

	@Override
	public PermitStatistics getStatistics() {
		int totalPermits = permitRepository.findAll().size();
		int validPermits = permitRepository.findByStatus("APPROVED").size();
		int invalidPermits = permitRepository.findByStatus("DENIED").size();
		int activePermits = permitRepository.findActive(new Date(System.currentTimeMillis())).size();
		int inactivePermits = permitRepository.findInactive(new Date(System.currentTimeMillis())).size();
		int dailyPermits = permitRepository.findByTypeAndStatus("daily", "APPROVED").size();
		int weeklyPermits = permitRepository.findByTypeAndStatus("weekly", "APPROVED").size();
		int monthlyPermits = permitRepository.findByTypeAndStatus("monthly", "APPROVED").size();
		return new PermitStatistics(totalPermits, validPermits, invalidPermits, activePermits, inactivePermits,
				dailyPermits, weeklyPermits, monthlyPermits);
	}

	@Override
	public ResponseEntity<List<Permit>> getSupervisorPermits(int supervisorId) {
		List<Permit> permits = permitRepository.findAll();
		List<Permit> supervisorPermits = new ArrayList<Permit>();
		for (int i = 0; i < permits.size(); i++) {
			if (permits.get(i).getUser().getDept().getSupervisor() == userRepository.findByUserID(supervisorId)
					.getUserID()) {
				supervisorPermits.add(permits.get(i));
			}
		}
		return new ResponseEntity<List<Permit>>(supervisorPermits, HttpStatus.OK);
	}

}
