package group15.intranet.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import group15.intranet.entity.Department;
import group15.intranet.entity.Permit;
import group15.intranet.entity.User;

public class UserIdInPermitSpecification {
	public static Specification<Permit> buildQuery(List<Integer> userIds) {
		return new Specification<Permit>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Permit> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				CriteriaQuery<Permit> criteriaQuery = 
						  builder.createQuery(Permit.class);
				In<Integer> inClause = builder.in(root.get("user"));
				for (Integer userId : userIds) {
					inClause.value(userId);
				}
				return (Predicate) criteriaQuery.select(root).where(inClause);
			}
		};
	}
}
