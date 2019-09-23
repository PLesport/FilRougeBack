package fr.plesport.pfr.model.criteria;

import java.time.LocalDateTime;

import org.springframework.util.StringUtils;

public class BlogSearchCriteria {

	private Long id;
	private String title;
	private String header;
	private LocalDateTime date;

	public BlogSearchCriteria() {
	}


	public BlogSearchCriteria(Long id, String title, String header, LocalDateTime date) {
		super();
		this.id = id;
		this.title = title;
		this.header = header;
		this.date = date;

	}


	public boolean hasCriterias() {
		return id != null || !StringUtils.isEmpty(title) || !StringUtils.isEmpty(header)
				|| date != null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


}
