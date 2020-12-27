package group15.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.entity.Department;
import group15.intranet.entity.Permit;
import group15.intranet.entity.Role;
import group15.intranet.entity.User;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

	Department findById(int dept_id);

	List<Department> findAll();
}
