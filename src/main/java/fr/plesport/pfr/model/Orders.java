package fr.plesport.pfr.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name = "orders")
@SequenceGenerator(name = "sequence-orders", sequenceName = "sequenceOrders", initialValue = 1, allocationSize = 1)
public class Orders implements IdEntity {

	private static final long serialVersionUID = -7660929552633136535L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator="sequence-orders")
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime date;
	
	@NotBlank
	private String shippingAdress;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private OrdersStatus ordersStatus;

	@NotNull
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private List<OrderLine> orderLine;
	
	@ManyToOne
	@JoinColumn(name = "userid_id")
	private User user;

	public Orders() {
	}

	public Orders(User user, LocalDateTime date, String shippingAdress, List<OrderLine> orderLine) {
		this.orderLine = orderLine;
		this.user = user;
		this.date = date;
		this.shippingAdress = shippingAdress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public void setId(Long id) {
		this.id=id;
	}

	public OrdersStatus getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(OrdersStatus ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
	
	

}
