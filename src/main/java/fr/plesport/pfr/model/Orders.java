package fr.plesport.pfr.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Orders implements IdEntity {

	private static final long serialVersionUID = -7660929552633136535L;

	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime date;
	@NotBlank
	private String shippingAdress;

	@NotNull
	@OneToMany(mappedBy = "orders")
	private List<OrderLine> orderLine;
	@ManyToOne
	private User userId;

	public Orders() {
	}

	public Orders(User user, LocalDateTime date, String shippingAdress, List<OrderLine> orderLine) {
		this.orderLine = orderLine;
		this.userId = user;
		this.date = date;
		this.shippingAdress = shippingAdress;
	}

	public User getUser() {
		return userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getShippingAdress() {
		return shippingAdress;
	}

	public void setShippingAdress(String shippingAdress) {
		this.shippingAdress = shippingAdress;
	}

	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
