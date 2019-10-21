package fr.plesport.pfr.controller;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@PreAuthorize("hasAuthority('C_USER')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid User user) {
		userService.createUser(user);
	}

	@PreAuthorize("hasAuthority('D_USER')")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteUser(@PathVariable Long id) {
		User user = userService.findUserById(id);
		userService.deleteUser(user);
	}

	@PostAuthorize("hasAuthority('F_USER') or returnObject.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@PreAuthorize("hasAuthority('F_USER') or #email == principal.username")
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	@ResponseBody
	public User findUserByEmail(@PathVariable String email) {
		return userService.findUserByEmail(email);
	}

	@PreAuthorize("hasAuthority('F_USER')")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}

	@PreAuthorize("hasAuthority('U_USER') or #user.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	@PreAuthorize("hasAuthority('F_USER')")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(
			@RequestParam(name = "clientNumber", required = false) Long id,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String postalCode,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String phoneNumber,
			@RequestParam(required = false) Integer fidelityPoints,
			@RequestParam(required = false) String email){
		UserSearchCriteria criteria = new UserSearchCriteria(id, lastName, postalCode, city, phoneNumber, fidelityPoints, email);
		
		return userService.search(criteria);
		
	}
	
	@RequestMapping("/validateLogin")
	public Principal validateLogin(Principal principal) {
		return principal;
	}

}
