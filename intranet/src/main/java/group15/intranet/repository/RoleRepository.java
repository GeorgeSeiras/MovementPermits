package group15.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import group15.intranet.entity.Role;
import group15.intranet.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

	User findById(int user_id);

}
