package group15.intranet.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import group15.intranet.entity.Permit;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Integer>, JpaSpecificationExecutor<Permit> {

	Permit findById(int permit_id);

	List<Permit> findAll(Specification<Permit> spec);
	
	List<Permit> findByStatus(String status);
	
	List<Permit> findByType(String type);
	
	List<Permit> findByTypeAndStatus(String type,String status);

	
	@Query("select p from Permit p where p.startDate< ?1 and p.endDate> ?1")
	List<Permit> findActive(Date curDate);
	
	@Query("select p from Permit p where p.startDate> ?1 or p.endDate< ?1")
	List<Permit> findInactive(Date curDate);
	
	
	
	
	
}
