package group15.intranet.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import group15.intranet.entity.Department;
import group15.intranet.entity.Permit;
import group15.intranet.entity.User;

public class JoinUserDepSpecification {
	public static Specification<User> buildQuery(int id) {
		return new Specification<User>() {
			private static final long serialVersionUID = -5072065538523887184L;

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				
				Join<User,Department> userProd = root.join("dept");
				return builder.equal(userProd.get("deptID"),id);

			}
	};
}
}
