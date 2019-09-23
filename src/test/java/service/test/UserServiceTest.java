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
		User user = new User(UserCivility.MR, "Jean", "Foutre", "70 rue de la sodomie", "Pornhub", "34000", 612589636,
				"foutre@gmail.com", "jolzrej", false);
		userService.createUser(user);
	}
	
	
}
