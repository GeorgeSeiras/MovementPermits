package group15.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import group15.intranet.entity.Permit;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Integer>{

}
