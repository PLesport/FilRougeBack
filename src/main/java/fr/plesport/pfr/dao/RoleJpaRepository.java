package fr.plesport.pfr.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.plesport.pfr.model.Role;

@Repository
@Transactional
public class RoleJpaRepository extends AbstractJpaRepository<Role> {

	public RoleJpaRepository() {
		super(Role.class);
	}
}
