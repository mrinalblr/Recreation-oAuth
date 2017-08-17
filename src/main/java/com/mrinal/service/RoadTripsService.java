package com.mrinal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrinal.model.RoadTrips;
import com.mrinal.repo.RoadTripsRepo;
import com.mrinal.response.GenericResponse;
import com.mrinal.response.RoadTripsResponse;

@Service
public class RoadTripsService {

	@Autowired
	RoadTrips roadTrips;
	
	@Autowired
	RoadTripsRepo rtRepo;
	
	@Autowired
	GenericResponse gResponse;
	
	public ResponseEntity<GenericResponse> addTrips(RoadTrips trips){
		try{
			System.out.println(trips.getDescription());
			rtRepo.save(trips);	
			gResponse = new GenericResponse("SUCCESS", "Successfully Created", "", HttpStatus.CREATED);
			
		}
		catch(Exception e){
			gResponse = new GenericResponse("FAILURE", "", e.getMessage(), HttpStatus.BAD_REQUEST);
			return new ResponseEntity<GenericResponse>(gResponse,HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<GenericResponse>(gResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<GenericResponse> fetchAllTrips(){
		try{
			List<RoadTrips> trips = (List<RoadTrips>)rtRepo.findAll();
			gResponse = new RoadTripsResponse("SUCCESS", "Successfully fetched","",HttpStatus.FOUND, trips);
		}
		catch(Exception e){
			gResponse = new GenericResponse("FAILURE", "", e.getMessage(), HttpStatus.BAD_REQUEST);
			return new ResponseEntity<GenericResponse>(gResponse,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<GenericResponse>(gResponse,HttpStatus.OK);
	}
}
