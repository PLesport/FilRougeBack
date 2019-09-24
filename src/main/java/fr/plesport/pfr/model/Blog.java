package fr.plesport.pfr.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "blog")
@SequenceGenerator(name = "sequence-blog", sequenceName = "sequenceBlog", initialValue = 1, allocationSize = 1)
public class Blog implements IdEntity{

	private static final long serialVersionUID = 7115463390856692329L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator="sequence-blog")
	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String header;
	@NotNull
	private LocalDateTime date;
	@NotBlank
	private String body;

	public Blog() {
	}

	public Blog(String title, String header, LocalDateTime date, String body) {
		this.title = title;
		this.header = header;
		this.date = date;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
	this.id=id;	
	}

}
