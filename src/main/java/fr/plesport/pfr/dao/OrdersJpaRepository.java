package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.Orders;
import fr.plesport.pfr.model.criteria.OrdersSearchCriteria;

@Repository
public class OrdersJpaRepository extends AbstractJpaRepository<Orders> {
	public OrdersJpaRepository() {
		super(Orders.class);
	}

	public List<Orders> search(OrdersSearchCriteria criteria) {
		String qlQuery = "from Orders o";
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
		}
		if (criteria.getId() != null) {
			qlQuery += " and o.id = :id";
		}
		if (criteria.getDate() != null) {
			qlQuery += " and o.date = :date";
		}
		if (!StringUtils.isEmpty(criteria.getShippingAddress())) {
			qlQuery += " and (lowero.shippingAddress) :shippingAddress";
		}

		TypedQuery<Orders> query = em.createQuery(qlQuery, Orders.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (criteria.getDate() != null) {
				query.setParameter("date", criteria.getDate());
			}
			if (!StringUtils.isEmpty(criteria.getShippingAddress())) {
				String shippingAddress = criteria.getShippingAddress().toLowerCase();
				query.setParameter("shippingAddress", shippingAddress);
			}
		}

		return query.getResultList();
	}
}
