package fr.plesport.pfr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.criteria.UserSearchCriteria;
import fr.plesport.pfr.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteUser(@RequestBody Long id) {
		User user = userService.findUserById(id);
		userService.deleteUser(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(
			@RequestParam(name = "clientNumber", required = false) Long id,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String postalCode,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String phoneNumber,
			@RequestParam(required = false) Integer fidelityPoints) {
		UserSearchCriteria criteria = new UserSearchCriteria(id, lastName, postalCode, city, phoneNumber, fidelityPoints);
		
		return userService.search(criteria);
		
	}

}
