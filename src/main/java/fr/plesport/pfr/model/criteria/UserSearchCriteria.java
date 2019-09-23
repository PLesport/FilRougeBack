package fr.plesport.pfr.model.criteria;

import org.springframework.util.StringUtils;

public class UserSearchCriteria {
	private Long id;
	private String lastName;
	private String postalCode;
	private String city;
	private String phoneNumber;

	public UserSearchCriteria() {
	}

	public UserSearchCriteria(Long id, String lastName, String postalCode, String city, String phoneNumber) {
		this.id = id;
		this.lastName = lastName;
		this.postalCode = postalCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	public boolean hasCriterias() {
		return id != null || !StringUtils.isEmpty(lastName) || !StringUtils.isEmpty(postalCode)
				|| !StringUtils.isEmpty(city) || !StringUtils.isEmpty(phoneNumber);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
