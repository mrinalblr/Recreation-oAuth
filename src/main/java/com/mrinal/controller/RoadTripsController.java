package com.mrinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.model.RoadTrips;
import com.mrinal.response.GenericResponse;
import com.mrinal.service.RoadTripsService;

@RestController
@RequestMapping("/roadTrips")
public class RoadTripsController {
	
	@Autowired
	RoadTripsService rts;

	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/addRoadTrips",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GenericResponse> addRoadTrips(@RequestBody RoadTrips trips){
		
		return rts.addTrips(trips);
	}
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/getAllTrips",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<GenericResponse> fetchAllTrips(){
		return rts.fetchAllTrips();
	}
	
	
}
