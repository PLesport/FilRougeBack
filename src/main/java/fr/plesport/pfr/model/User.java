package fr.plesport.pfr.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_")
public class User implements IdEntity {

	private static final long serialVersionUID = -8754964535672771858L;

	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	@NotBlank
	private UserCivility civility;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String adress;
	@NotBlank
	private String city;
	@NotBlank
	@Length(min = 5, max = 5)
	private String postalCode;
	@NotBlank
	@Length(min = 10, max = 10)
	private String phoneNumber;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;
	private boolean admin;

	@OneToMany(mappedBy = "userId")
	private List<Orders> order;

	public User() {
	}

	public User(UserCivility civility, String firstName, String lastName, String adress, String city, String postalCode,
			String phoneNumber, String email, String password, boolean admin) {
		this.civility = civility;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserCivility getCivility() {
		return civility;
	}

	public void setCivility(UserCivility civility) {
		this.civility = civility;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
	}

}
