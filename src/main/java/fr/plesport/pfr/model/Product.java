package fr.plesport.pfr.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "sequence-product", sequenceName = "sequenceProduct", initialValue = 1, allocationSize = 1)
public class Product implements IdEntity {
	private static final long serialVersionUID = -6869463480573840946L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator="sequence-product")
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotBlank
	private String reference;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ProductType type;
	@NotBlank
	private String origin;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ProductPackaging packaging;
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private BigDecimal price;
	@NotNull
	private Integer discountRate;
	@NotNull
	private Integer stock;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ProductAvailability status;
	@NotBlank
	private String url;
	@NotBlank
	private String attributes;

	@OneToMany(mappedBy = "product")
	private List<OrderLine> orderLines;

	public Product() {
	}

	public Product(String name, String description, String reference, ProductType type, String origin,
			ProductPackaging packaging, BigDecimal price, Integer discountRate, Integer stock,
			ProductAvailability status) {
		this.name = name;
		this.description = description;
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

	public void setId(Long id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
