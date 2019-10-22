package fr.plesport.pfr.model.criteria;

import fr.plesport.pfr.model.Orders;

public class OrderLineSearchCriteria {
	private Long id;
	private Integer quantity = 0;
	private Orders order;

	public OrderLineSearchCriteria() {
	}

	public OrderLineSearchCriteria(Long id, Integer quantity, Orders order) {
		this.id = id;
		this.quantity = quantity;
		this.order=order;
	}

	public boolean hasCriterias() {
		return id != null || quantity != null || order != null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
}
