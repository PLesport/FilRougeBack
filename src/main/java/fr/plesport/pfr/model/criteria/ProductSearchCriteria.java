package fr.plesport.pfr.model.criteria;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.ProductAvailability;
import fr.plesport.pfr.model.ProductPackaging;
import fr.plesport.pfr.model.ProductType;

public class ProductSearchCriteria {

	private Long id;
	private String name;
	private String description;
	private String reference;
	private ProductType type;
	private String origin;
	private ProductPackaging packaging;
	private BigDecimal price;
	private Integer discountRate;
	private Integer stock;
	private ProductAvailability status;

	public ProductSearchCriteria() {
	}

	public ProductSearchCriteria(Long id,String name,String description, String reference, ProductType type, String origin, ProductPackaging packaging,
			BigDecimal price, Integer discountRate, Integer stock, ProductAvailability status) {
		this.id = id;
		this.name=name;
		this.description=description;
		this.reference = reference;
		this.type = type;
		this.origin = origin;
		this.packaging = packaging;
		this.price = price;
		this.discountRate = discountRate;
		this.stock = stock;
		this.status = status;
	}

	public boolean hasCriterias() {
		return id != null || !StringUtils.isEmpty(name)||!StringUtils.isEmpty(description)|| !StringUtils.isEmpty(reference) || type != null || !StringUtils.isEmpty(origin)
				|| packaging != null || price != null || discountRate != null || stock != null || status != null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
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
	
	
}
