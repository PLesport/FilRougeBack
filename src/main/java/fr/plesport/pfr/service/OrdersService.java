package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.OrdersJpaRepository;
import fr.plesport.pfr.model.Orders;
import fr.plesport.pfr.model.criteria.OrdersSearchCriteria;

@Service
public class OrdersService {

	@Autowired
	private OrdersJpaRepository ordersJpaRepository;

	public void createOrders(Orders orders) {
		ordersJpaRepository.persist(orders);
	}

	public void deleteOrders(Orders orders) {
		ordersJpaRepository.delete(orders);
	}

	public void updateOrders(Orders orders) {
		ordersJpaRepository.update(orders);
	}

	public Orders findOrdersById(Long id) {
		return ordersJpaRepository.find(id);
	}
	
public List<Orders> findOrdersByUserId(Long id) {
	return ordersJpaRepository.findByUserId(id);
	}

	public List<Orders> findAll() {
		return ordersJpaRepository.findAll();
	}

	public List<Orders> search(OrdersSearchCriteria criteria) {
		return ordersJpaRepository.search(criteria);
	}
}
	
