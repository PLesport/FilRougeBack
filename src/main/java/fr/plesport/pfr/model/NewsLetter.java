package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
@Entity
@Table(name = "newsletter")
public class NewsLetter implements IdEntity{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Email
	private String email;
	
	public NewsLetter() {
	}

	public NewsLetter(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
	}


	

}
