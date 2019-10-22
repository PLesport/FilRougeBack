package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.plesport.pfr.model.IdEntity;

@Repository
@Transactional
public abstract class AbstractJpaRepository<T extends IdEntity> {

	private Class<T> classType;

	@PersistenceContext
	protected EntityManager em;

	public AbstractJpaRepository() {
	}

	protected AbstractJpaRepository(Class<T> type) {
		this.classType = type;
	}

	public void persist(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public T find(Long id) {
		return em.find(classType, id);
	}
	
	public List<T> findAll() {
		TypedQuery<T> query = em.createQuery("from " + classType.getSimpleName(), classType);
		return query.getResultList();
	}
	
	

}
