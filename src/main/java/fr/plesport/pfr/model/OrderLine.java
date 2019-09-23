package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderline")
public class OrderLine implements IdEntity {

	private static final long serialVersionUID = -1441316288922066723L;
	@Id
	@GeneratedValue
	private Long id;
	private Integer quantity = 0;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Orders orders;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
	}

}
