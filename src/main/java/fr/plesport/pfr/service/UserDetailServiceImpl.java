package fr.plesport.pfr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.plesport.pfr.model.User;

public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserService userService;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userService.findUserByEmail(email);
		
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(email);
	      builder.password(user.getPassword());
	      builder.roles(user.getRole().getName());
	      
	      List<GrantedAuthority> authorities = user.getRole().getRights().stream()
	    		  .map(right -> new SimpleGrantedAuthority(right.getName()))
	    		  .collect(Collectors.toList());
	      builder.authorities(authorities);
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	}
}

