package fr.plesport.pfr.dao;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.plesport.pfr.model.NewsLetter;

@Repository
@Transactional
public class NewsLetterJpaRepository extends AbstractJpaRepository<NewsLetter> {
	public NewsLetterJpaRepository() {
		super(NewsLetter.class);
	}

	public NewsLetter findNewsLetterByEmail(String email) {
		TypedQuery<NewsLetter> query = em.createQuery("from NewsLetter n where n.email = :email", NewsLetter.class);
		query.setParameter("email", email);
		return query.getSingleResult();

	}
}
