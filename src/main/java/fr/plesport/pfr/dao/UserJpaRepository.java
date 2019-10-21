package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.criteria.UserSearchCriteria;

@Repository
public class UserJpaRepository extends AbstractJpaRepository<User> {

	public UserJpaRepository() {
		super(User.class);
	}
	
	public User findByEmail(String email) {
		String qlQuery = "from User u left join fetch u.role r left join fetch r.rights where u.email = :email";
		
		TypedQuery<User> query = em.createQuery(qlQuery, User.class);
		query.setParameter("email", email);
		
		User user = query.getSingleResult();
		
		return user;
	}
	
	public List<User> search(UserSearchCriteria criteria) {
		String qlQuery = "from User u";
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
		}
		if (criteria.getId() != null) {
			qlQuery += " and u.id = :id";
		}
		if (!StringUtils.isEmpty(criteria.getLastName())) {
			qlQuery += " and lower(u.lastName) like :lastName";
		}
		if (!StringUtils.isEmpty(criteria.getPostalCode())) {
			qlQuery += " and u.postalCode = :postalCode";
		}
		if (!StringUtils.isEmpty(criteria.getCity())) {
			qlQuery += " and lower(u.city) = :city";
		}
		if (!StringUtils.isEmpty(criteria.getPhoneNumber())) {
			qlQuery += " and u.phoneNumber = :phoneNumber";
		}
		if (criteria.getFidelityPoints() != null) {
			qlQuery += " and u.fidelityPoints = :fidelityPoints";
		}
		if (!StringUtils.isEmpty(criteria.getEmail())) {
			qlQuery += " and u.email = :email";
		}
		TypedQuery<User> query = em.createQuery(qlQuery, User.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (!StringUtils.isEmpty(criteria.getLastName())) {
				String lastName = criteria.getLastName().toLowerCase();
				query.setParameter("lastName", "%"+ lastName + "%");
			}
			if (!StringUtils.isEmpty(criteria.getPostalCode())) {
				query.setParameter("postalCode", criteria.getPostalCode());
			}
			if (!StringUtils.isEmpty(criteria.getCity())) {
				String city = criteria.getCity().toLowerCase();
				query.setParameter("city", city);
			}
			if (!StringUtils.isEmpty(criteria.getPhoneNumber())) {
				query.setParameter("phoneNumber", criteria.getPhoneNumber());
			}
			if (criteria.getFidelityPoints() != null) {
				query.setParameter("fidelityPoints", criteria.getFidelityPoints());
			}
			
			if (!StringUtils.isEmpty(criteria.getEmail())) {
				query.setParameter("email", criteria.getEmail());
			}
		}

		return query.getResultList();
	}

}
