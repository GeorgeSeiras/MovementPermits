package group15.intranet.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Permit;
import group15.intranet.entity.User;

public class JoinPermitUserSpecification {

	public static Specification<Permit> buildQuery(String fname, String lname) {
		return new Specification<Permit>() {
			private static final long serialVersionUID = -5072065538523887184L;

			@Override
			public Predicate toPredicate(Root<Permit> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				
				Join<Permit,User> userProd = root.join("user");
				return builder.and(
								builder.like(userProd.get("fname"), "%" + fname +"%"),
						builder.like(userProd.get("lname"), "%" + lname +"%"));

			}
	};
}
}
