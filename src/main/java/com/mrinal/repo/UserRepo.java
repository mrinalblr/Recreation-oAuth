package com.mrinal.repo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.mrinal.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByemailId(String emailId);
	public ArrayList<User> findAll();
	
	@Query(value="select * from User",nativeQuery=true)
	List<User> findUsers();
	
	@Query(value="select * from User where USER_ID =?1",nativeQuery=true)
	User findByid(int id);
	
	
	
	
	
}
