package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.OrderLineJpaRepository;
import fr.plesport.pfr.model.OrderLine;
import fr.plesport.pfr.model.criteria.OrderLineSearchCriteria;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineJpaRepository orderLineJpaRepository;

	public void createOrderLine(OrderLine orderLine) {
		orderLineJpaRepository.persist(orderLine);
	}

	public void deleteOrderLine(OrderLine orderLine) {
		orderLineJpaRepository.delete(orderLine);
	}

	public void updateOrderLine(OrderLine orderLine) {
		orderLineJpaRepository.update(orderLine);
	}

	public OrderLine findOrderLineById(Long id) {
		return orderLineJpaRepository.find(id);
	}

	public List<OrderLine> findAll() {
		return orderLineJpaRepository.findAll();
	}
	public List<OrderLine> findOrderLineByOrderId(Long id) {
		return orderLineJpaRepository.findOrderLineByOrderId(id);
	}
	
	public List<OrderLine> search(OrderLineSearchCriteria criteria) {
		return orderLineJpaRepository.search(criteria);
	}
}
