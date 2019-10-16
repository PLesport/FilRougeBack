package service.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.plesport.pfr.App;
import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.UserCivility;
import fr.plesport.pfr.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void createTest() {
		User user = new User(UserCivility.MR, "Jean", "Bonbeur", "12,  Rue des pins","Montpellier", "34000", "0123456789", "jean.bonbeur@gmail.com", "jeanbonbeur", false);
		userService.createUser(user);
	}
	
	@Test
	public void createSameUserTest() {
		User user = new User(UserCivility.MR, "Jean", "Bonbeur", "12,  Rue des pins","Montpellier", "34000", "0123456789", "jean.bonbeur@gmail.com", "jeanbonbeur", false);
		userService.createUser(user);
	}
	
	@Test
	public void createNullUser() {
		User user = null;
		userService.createUser(user);
	}
	
	@Test
	public void updateUserTest() {
		User user = new User(UserCivility.MR, "Jean", "Bonbeur", "54,  Rue des moufles","Paris", "75000", "0123456789", "jean.bonbeur@gmail.com", "jeanbonbeur", false);
		userService.updateUser(user);
	}
	
	@Test
	public void findUserByIdTest() {
		Long id = 1L;
		userService.findUserById(id);
	}
	
	@Test
	public void deleteUserTest() {
		Long id = 1L;
		User user = userService.findUserById(id);
		userService.deleteUser(user);
	}
}
