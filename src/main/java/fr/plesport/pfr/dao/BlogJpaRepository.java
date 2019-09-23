package fr.plesport.pfr.dao;

import java.time.LocalDateTime;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.Blog;
import fr.plesport.pfr.model.criteria.BlogSearchCriteria;

@Repository
public class BlogJpaRepository extends AbstractJpaRepository<Blog> {

	public BlogJpaRepository() {
		super(Blog.class);
	}

	@Transactional
	public Blog search(BlogSearchCriteria criteria) {
		String qlQuery = "from Blog b";
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
		}
		if (criteria.getId() != null) {
			qlQuery += " and u.id = :id";
		}
		if (!StringUtils.isEmpty(criteria.getTitle())) {
			qlQuery += " and u.lastName = :title";
		}
		if (!StringUtils.isEmpty(criteria.getHeader())) {
			qlQuery += " and u.postalCode = :header";
		}
		if (!StringUtils.isEmpty(criteria.getDate())) {
			qlQuery += " and lower(u.city) like :date";
		}

		TypedQuery<Blog> query = em.createQuery(qlQuery, Blog.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (!StringUtils.isEmpty(criteria.getTitle())) {
				String lastName = criteria.getTitle().toLowerCase();
				query.setParameter("title", "%" + lastName + "%");
			}
			if (!StringUtils.isEmpty(criteria.getHeader())) {
				query.setParameter("header", criteria.getHeader());
			}
			if (!StringUtils.isEmpty(criteria.getDate())) {
				LocalDateTime date = criteria.getDate();
				query.setParameter("city", criteria.getDate());
			}
		}
		return query.getSingleResult();
	}
}
