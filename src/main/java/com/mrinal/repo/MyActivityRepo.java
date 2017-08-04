package com.mrinal.repo;

import org.springframework.data.repository.CrudRepository;

import com.mrinal.model.MyActivities;

public interface MyActivityRepo extends CrudRepository<MyActivities, Integer> {

	
}
