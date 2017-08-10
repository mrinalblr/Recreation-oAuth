package com.mrinal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrinal.exception.RecordNotFoundException;
import com.mrinal.exception.UserNotFoundException;
import com.mrinal.model.MyActivity;
import com.mrinal.model.Sports;
import com.mrinal.repo.MyActivityRepo;
import com.mrinal.repo.SportsRepo;
import com.mrinal.response.GenericResponse;
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
	public ResponseEntity<GenericResponse> fetchSpecificSports(Sports sports){
		SpecificSportsResponse response = null;
		ArrayList<Sports> fetchedSports=null;
		try{
			if(sports.getSportsName()!=null){
				 fetchedSports = srp.findAllBySportsName(sports.getSportsName());
				 if(fetchedSports.size()==0){
					 throw new RecordNotFoundException("No record found specific to "+sports.getSportsName(), HttpStatus.NOT_FOUND);
				 }else{
					 response = new SpecificSportsResponse("SUCCESS","Sports List Fetched Successfully","None",fetchedSports);
			}
			}
		}catch(RecordNotFoundException exp){
        	GenericResponse gr = new GenericResponse("FAILED","",exp.getErrorMsg(),exp.getStatusCode());
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.NOT_FOUND);
		}
		catch(Exception e){
			e.printStackTrace();
			response = new SpecificSportsResponse("SUCCESS","UNABLE TO FETCH", "FAILURE");
		}
		
		
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<GenericResponse> addActivity(Sports sports){
		MyActivity act = new MyActivity();
		try{
			act.setActivityId(sports.getSportsId());
			act.setActivtyName(sports.getSportsName());
	        act.setActivityHost(sports.getHost());
	        act.setActivityVenue(sports.getVenue());
	        act.setActivityDate(sports.getDate());
	        act.setActivityTime(sports.getTime());
	        act.setActivityDescription(sports.getDescription());
	        act.setStatus("ACTIVE");
        ar.save(act);
		}catch(DataIntegrityViolationException d){
			GenericResponse gr = new GenericResponse("FAILURE","","Duplicate entry not allowed",HttpStatus.BAD_REQUEST);
			return new ResponseEntity<GenericResponse>(gr,HttpStatus.BAD_REQUEST);
		}
        GenericResponse gr = new GenericResponse("SUCCESS","","",HttpStatus.CREATED);
        		
		return new ResponseEntity<GenericResponse>(gr,HttpStatus.OK);
	}
	
}
