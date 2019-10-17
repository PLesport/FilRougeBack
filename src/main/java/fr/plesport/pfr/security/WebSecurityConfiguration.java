package fr.plesport.pfr.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.plesport.pfr.service.UserDetailServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
            .and().authorizeRequests()
            .antMatchers("/api/newsletter/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/blog/**", "/api/products/**").permitAll()
            .antMatchers("/api/orders/**", "/api/orderlines/**", "/api/users/**").authenticated()
            .antMatchers("/api/**").authenticated()
            .and().csrf().disable()
            .formLogin().disable();
    }
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
      return new UserDetailServiceImpl();
    };
    
    @Bean
    protected PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
