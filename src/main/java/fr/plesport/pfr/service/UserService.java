package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.UserJpaRepository;
import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.criteria.UserSearchCriteria;
import fr.plesport.pfr.security.WebSecurityConfiguration;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void createUser(User user) {	
		passwordEncoder.encode("password");
		userJpaRepository.persist(user);
	}

	public void deleteUser(User user) {
		userJpaRepository.delete(user);
	}

	public void updateUser(User user) {
		userJpaRepository.update(user);
	}

	public User findUserById(Long id) {
		return userJpaRepository.find(id);
	}
	
	public User findUserByEmail(String email) {
		return userJpaRepository.findByEmail(email);
	}

	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	public List<User> search(UserSearchCriteria criteria) {
		return userJpaRepository.search(criteria);
	}

}
