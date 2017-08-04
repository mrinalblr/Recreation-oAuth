package com.mrinal.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mrinal.model.User;
import com.mrinal.model.UserDetails;

public interface UserDetailsRepo extends CrudRepository<UserDetails, Integer> {
	
	
}
