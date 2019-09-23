package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.UserJpaRepository;
import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.criteria.UserSearchCriteria;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;

	public void createUser(User user) {
	if (user.getPhoneNumber().chars().allMatch(Character::isDigit)) {
			userJpaRepository.persist(user);}
	else
	
		
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

	public List<User> findAll() {
		return userJpaRepository.findAll();
	}
	
	public List<User> search(UserSearchCriteria criteria) {
		return userJpaRepository.search(criteria);
	}
}
