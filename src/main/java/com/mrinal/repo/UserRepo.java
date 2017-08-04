package com.mrinal.repo;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mrinal.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	public User findByemailId(String emailId);
	public ArrayList<User> findAll();
	public User findUserById(int id);
	
	
	
}
