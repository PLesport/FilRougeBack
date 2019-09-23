package fr.plesport.pfr.model.criteria;

public class OrderLineSearchCriteria {
	private Long id;
	private Integer quantity = 0;

	public OrderLineSearchCriteria() {
	}

	public OrderLineSearchCriteria(Long id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public boolean hasCriterias() {
		return id != null || quantity != 0;
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
}
