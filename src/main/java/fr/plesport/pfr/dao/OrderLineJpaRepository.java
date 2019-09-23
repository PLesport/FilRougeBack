package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.plesport.pfr.model.OrderLine;
import fr.plesport.pfr.model.criteria.OrderLineSearchCriteria;

@Repository
public class OrderLineJpaRepository extends AbstractJpaRepository<OrderLine> {
	public OrderLineJpaRepository() {
		super(OrderLine.class);
	}

	public List<OrderLine> search(OrderLineSearchCriteria criteria) {
		String qlQuery = "from OrderLine ol";
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
		}
		if (criteria.getId() != null) {
			qlQuery += " and ol.id = :id";
		}
		if (criteria.getQuantity() != null) {
			qlQuery += " and ol.quantity = :quantity";
		}

		TypedQuery<OrderLine> query = em.createQuery(qlQuery, OrderLine.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (criteria.getQuantity() != null) {
				query.setParameter("quantity", criteria.getQuantity());
			}
		}
		return query.getResultList();
	}
}
