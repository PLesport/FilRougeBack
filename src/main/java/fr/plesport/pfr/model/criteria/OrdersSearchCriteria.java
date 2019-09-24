package fr.plesport.pfr.model.criteria;

import java.time.LocalDateTime;

import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.OrdersStatus;

public class OrdersSearchCriteria {

	private Long id;
	private LocalDateTime date;
	private String shippingAddress;
	private OrdersStatus ordersStatus;

	public OrdersSearchCriteria() {
	}

	public OrdersSearchCriteria(Long id, LocalDateTime date, String shippingAddress, OrdersStatus ordersStatus) {
		this.id = id;
		this.date = date;
		this.shippingAddress = shippingAddress;
		this.ordersStatus = ordersStatus;
	}

	public boolean hasCriterias() {
		return id != null || date != null || !StringUtils.isEmpty(shippingAddress) || ordersStatus != null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public OrdersStatus getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(OrdersStatus ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
}
