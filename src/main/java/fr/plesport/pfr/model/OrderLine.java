package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderline")
public class OrderLine {
	@Id
	@GeneratedValue
	private Long id;
	private int quantity = 0;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Orders orders;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
