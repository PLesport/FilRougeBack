package fr.plesport.pfr.model.criteria;

import java.time.LocalDateTime;

import org.springframework.util.StringUtils;

public class OrdersSearchCriteria {

	private Long id;
	private LocalDateTime date;
	private String shippingAddress;

	public OrdersSearchCriteria() {
	}

	public OrdersSearchCriteria(Long id, LocalDateTime date, String shippingAddress) {
		this.id = id;
		this.date = date;
		this.shippingAddress = shippingAddress;
	}

	public boolean hasCriterias() {
		return id != null || date != null || !StringUtils.isEmpty(shippingAddress);
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
}
