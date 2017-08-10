package com.mrinal.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.model.Sports;
import com.mrinal.repo.SportsRepo;
import com.mrinal.response.GenericResponse;
import com.mrinal.response.SpecificSportsResponse;
import com.mrinal.response.SportsResponse;
import com.mrinal.response.UserResponse;
import com.mrinal.service.SportsService;

@RestController
@RequestMapping("/sports")
public class SportsController {

	@Autowired
	SportsService ss;
	
	
	//@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/getAllSports",method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GenericResponse> getSports(@RequestBody Sports sports){
	
		return ss.fetchSpecificSports(sports);
	}
	
	//@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/addSports",method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SportsResponse> addSports(@RequestBody Sports sports){
		
		return ss.addNewSports(sports);
	}
	/* Adds users shortlisted/liked/loved activity from sports to the myActivities. 
	 * */
	//@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/addMyActivity",method=RequestMethod.POST)
	@ResponseBody
	public String addMyActivity(@RequestBody Sports sports){
	  return null;
		
	}
	@RequestMapping(value="/joinSport")
	public ResponseEntity<GenericResponse> joinSport(@RequestBody Sports sports){
		return ss.addActivity(sports);
		
	}

}
