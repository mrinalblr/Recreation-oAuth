package com.mrinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrinal.model.MyActivity;

public interface MyActivityRepo extends JpaRepository<MyActivity, Integer>{

	
}
