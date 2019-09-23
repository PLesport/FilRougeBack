package fr.plesport.pfr.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product implements IdEntity {
	private static final long serialVersionUID = -6869463480573840946L;

	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String reference;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private ProductType type;
	@NotBlank
	private String origin;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private ProductPackaging packaging;
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private BigDecimal price;
	private Integer discountRate;
	private Integer stock;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private ProductAvailability status;

	@OneToMany(mappedBy = "product")
	private List<OrderLine> orderLines;

//Constructeur Vide
	public Product() {
	}

//Constructeur pour Admin
	public Product(String reference, ProductType type, String origin, ProductPackaging packaging, BigDecimal price,
			Integer discountRate, Integer stock, ProductAvailability status) {
		this.reference = reference;
		this.type = type;
		this.origin = origin;
		this.packaging = packaging;
		this.price = price;
		this.discountRate = discountRate;
		this.stock = stock;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public ProductPackaging getPackaging() {
		return packaging;
	}

	public void setPackaging(ProductPackaging packaging) {
		this.packaging = packaging;
	}

	public BigDecimal getPrix() {
		return price;
	}

	public void setPrix(BigDecimal prix) {
		this.price = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public ProductAvailability getStatus() {
		return status;
	}

	public void setStatus(ProductAvailability status) {
		this.status = status;
	}

	public Integer getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
