package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.OrderLine;
import fr.plesport.pfr.model.Orders;
import fr.plesport.pfr.model.criteria.OrdersSearchCriteria;

@Repository
@Transactional
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
		if(criteria.getOrdersStatus()!=null) {
			qlQuery += " and o.ordersStatus = :ordersStatus";
		}	
		if (!StringUtils.isEmpty(criteria.getShippingAddress())) {
			qlQuery += " and lower(o.shippingAddress) :shippingAddress";
		}

		TypedQuery<Orders> query = em.createQuery(qlQuery, Orders.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (criteria.getDate() != null) {
				query.setParameter("date", criteria.getDate());
			}
			if (criteria.getOrdersStatus() != null) {
				query.setParameter("ordersStatus", criteria.getOrdersStatus());
			}
			if (!StringUtils.isEmpty(criteria.getShippingAddress())) {
				String shippingAddress = criteria.getShippingAddress().toLowerCase();
				query.setParameter("shippingAddress", shippingAddress);
			}
		}

		return query.getResultList();
	}

	public List<Orders> findByUserId(Long id) {
		TypedQuery<Orders> query = em.createQuery("from Orders o where o.user.id = :id", Orders.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	
}
