package com.mrinal.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrinal.model.ForgotPassword;
import com.mrinal.model.Music;
import com.mrinal.model.MyActivity;
import com.mrinal.model.RoadTrips;
import com.mrinal.model.Role;
import com.mrinal.model.Sports;
import com.mrinal.model.Trekking;
import com.mrinal.model.User;
import com.mrinal.model.UserDetails;

@Configuration
public class RecreationBean {

	@Bean
    public Music getMusic(){
    	return new Music();
    }
	
	@Bean
	public User getUser(){
		return new User();
	}
	
	@Bean
	public Sports getSport(){
		return new Sports();
	}
	@Bean
	public ForgotPassword getForgotPassword(){
		return new ForgotPassword();
	}
	@Bean
	public MyActivity getMyActivity(){
		return new MyActivity();
	}
	@Bean
	public RoadTrips getRoadTrips(){
		return new RoadTrips();
	}
	@Bean
	public Role getRole(){
		return new Role();
	}
	@Bean
	public Trekking getTrekking(){
		return new Trekking();
	}
	@Bean
	public UserDetails getUserDetails(){
		return new UserDetails();
	}
}
