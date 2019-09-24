package fr.plesport.pfr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "newsletter")
@SequenceGenerator(name = "sequence-newsletter", sequenceName = "sequenceNewsletter", initialValue = 1, allocationSize = 1)
public class NewsLetter implements IdEntity {

	private static final long serialVersionUID = -1096540764649301836L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator="sequence-newsletter")
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


	public void setId(Long id) {
		this.id=id;
	}

}
