package group15.intranet.repository;

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
	
	@Query("select p from Permit p where p.status= ?1")
	List<Permit> findByStatus(String status);
	
	
	
	
}
