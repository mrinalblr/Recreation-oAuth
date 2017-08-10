package com.mrinal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerconfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.headers().frameOptions().disable().and()
		   .authorizeRequests()
		   .antMatchers("/","/public").permitAll()
//		   .antMatchers("/private","/addUser","/users/getAllUsers","/users/getUserById{}","/users/getUserByEmail","/users/login"
//		   		+ "/users/register","/users/getUser/{userId}","/users/forgotPassword","/users/addUserDetails","/sports/getAllSports","/sports/addSports","/sports/addMyActivity","/sendEmail/testEmail").authenticated();
		   .antMatchers("/private").authenticated();
	}

}
