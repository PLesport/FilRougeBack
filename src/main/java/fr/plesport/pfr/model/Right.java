package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "_right")
public class Right implements IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String name;
	
	private Right() {
		
	}
	
	public Right(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
}
