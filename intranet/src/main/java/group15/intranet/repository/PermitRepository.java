package group15.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import group15.intranet.entity.Permit;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Integer>{

	@Query("SELECT p FROM Permits p WHERE p.status = ?1")
	List<Permit> filterPermits(String name);
}
