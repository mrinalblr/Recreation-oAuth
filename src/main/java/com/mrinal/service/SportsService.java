package com.mrinal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrinal.model.MyActivities;
import com.mrinal.model.Sports;
import com.mrinal.repo.MyActivityRepo;
import com.mrinal.repo.SportsRepo;
import com.mrinal.response.SpecificSportsResponse;
import com.mrinal.response.SportsResponse;

@Service
public class SportsService {

	@Autowired
	SportsRepo srp;
	
	@Autowired
	MyActivityRepo ar;
	public ResponseEntity<SportsResponse> addNewSports(Sports sports){
		Sports newSports=new Sports();
		SportsResponse response = null;
		String sportsId="";
		try{
			if(sports!=null){
				newSports.setSportsName(sports.getSportsName());
				newSports.setHost(sports.getHost());
				newSports.setVenue(sports.getVenue());
				newSports.setDate(sports.getDate());
				newSports.setTime(sports.getTime());
				newSports.setDescription(sports.getDescription());
				srp.save(newSports);
				sportsId = String.valueOf(newSports.getSportsId());
				response = new SportsResponse(sportsId, "SUCCESS","Sports added Successfully","None", newSports.getSportsName(), newSports.getHost(), newSports.getVenue(), newSports.getDate(),newSports.getTime(),newSports.getDescription());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			response = new SportsResponse("FAILURE","Unable to add sport");
      	  return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
	}
	public ResponseEntity<SpecificSportsResponse> fetchSpecificSports(Sports sports){
		SpecificSportsResponse response = null;
		ArrayList<Sports> fetchedSports=null;
		try{
			if(sports.getSportsName()!=null){
				 fetchedSports = srp.findAllBySportsName(sports.getSportsName());
				 response = new SpecificSportsResponse("SUCCESS","Sports List Fetched Successfully","None",fetchedSports);
			}
		}catch(Exception e){
			e.printStackTrace();
			response = new SpecificSportsResponse("SUCCESS","UNABLE TO FETCH", "FAILURE");
		}
		
		
		return new ResponseEntity<SpecificSportsResponse>(response, HttpStatus.OK);
	}
	public String addNewActivity(Sports sports){
		Sports s = new Sports();
		s =srp.findBysportsId(sports.getSportsId());
		MyActivities activity = new MyActivities(1, s);
		System.out.println("test"+activity.getSports().getSportsId());
		ar.save(activity);
		return "SUCCESS";
	}
}
