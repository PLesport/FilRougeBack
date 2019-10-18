package fr.plesport.pfr.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.plesport.pfr.model.Right;

@Repository
@Transactional
public class RightJpaRepository extends AbstractJpaRepository<Right> {
	
	public RightJpaRepository() {
		super(Right.class);
	}
}
