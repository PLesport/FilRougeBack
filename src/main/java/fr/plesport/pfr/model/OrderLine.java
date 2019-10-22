package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderline")
@SequenceGenerator(name = "sequence-orderline", sequenceName = "sequenceOrderline", initialValue = 1, allocationSize = 1)
public class OrderLine implements IdEntity {

	private static final long serialVersionUID = -1441316288922066723L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator="sequence-orderline")
	private Long id;
	
	@NotBlank
	private Integer quantity = 0;

	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

	@JsonIgnore
	@ManyToOne
	private Orders orders;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	

}
