package fr.plesport.pfr.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "_role")
public class Role implements IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String name;
	@ManyToMany
	private List<Right> rights;
	
	private Role() {
		
	}
	
	public Role(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Right> getRights() {
		return rights;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public void setRights(List<Right> rightsAdminList) {
		this.rights = rightsAdminList;
		
	}
	
	
}


