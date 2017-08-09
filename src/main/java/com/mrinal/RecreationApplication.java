package com.mrinal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mrinal.configuration.CustomUserDetails;
import com.mrinal.model.Role;
import com.mrinal.model.User;
import com.mrinal.model.UserDetails;
import com.mrinal.repo.UserRepo;
import com.mrinal.service.UserService;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.mrinal.controller","com.mrinal.service"})
@SpringBootApplication
public class RecreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecreationApplication.class, args);
	}
	
	//OAUTH CLIENT CREDENTIALS CONFIGURATION
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepo repository, UserService service) throws Exception {
		
		//Setup a default user if db is empty
		if (repository.count()==0)
			
			
			service.save(new User("user1", "test1","user1@test.com","123", Arrays.asList(new Role("ADMIN"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository));
	}

	/**
	 * We return an instance of our CustomUserDetails.
	 * @param repository
	 * @return
     */
	private UserDetailsService userDetailsService(final UserRepo repository) {
		
		User u = (User)repository.findByemailId("test");
		System.out.println("uname : "+u.getEmailId());
		System.out.println("password : "+u.getPassword());
		
		return emailId -> new CustomUserDetails(repository.findByemailId(emailId));
	}
}
