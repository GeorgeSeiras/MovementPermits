package group15.intranet.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Permit;

public class PermitSpecification {

	public static Specification<Permit> buildQuery(List<SearchCriteria> list) {
		return new Specification<Permit>() {
			private static final long serialVersionUID = -5072065538523887184L;

			@Override
			public Predicate toPredicate(Root<Permit> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				// create a new predicate list
				List<Predicate> predicates = new ArrayList<>();

				// add add criteria to predicates
				for (SearchCriteria criteria : list) {
					if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
						predicates
								.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
					} else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
						predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
					} else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
						predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
								criteria.getValue().toString()));
					} else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
						predicates.add(
								builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
					} else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
						predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
					} else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
						predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
					} else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								"%" + criteria.getValue().toString().toLowerCase() + "%"));
					} else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								criteria.getValue().toString().toLowerCase() + "%"));
					} else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								"%" + criteria.getValue().toString().toLowerCase()));
					} else if (criteria.getOperation().equals(SearchOperation.IN)) {
						predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
					} else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
						predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
					}
				}
				Predicate predicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
				return predicate;
			}
		};
	}
}