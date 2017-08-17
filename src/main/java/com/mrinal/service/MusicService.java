package com.mrinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrinal.exception.RecordNotFoundException;
import com.mrinal.model.Music;
import com.mrinal.model.Sports;
import com.mrinal.repo.MusicRepo;
import com.mrinal.response.GenericResponse;
import com.mrinal.response.MusicResponse;
import com.mrinal.response.SpecificSportsResponse;

@Service
public class MusicService {

	@Autowired
	MusicRepo mr;
	
    @Autowired
    Music musicAct;
    
    
	public ResponseEntity<GenericResponse> addMusicActivity(Music music){
		
		musicAct.setMusicName(music.getMusicName());
		System.out.println("Test : "+musicAct.getMusicName());
		mr.save(music);
		return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS","","",HttpStatus.OK),HttpStatus.OK);
	}
	public ResponseEntity<GenericResponse> fetchAllMusic(Music music){
		
		GenericResponse response = null;
		ArrayList<Music> fetchedMusic=null;
		try{
			if(music.getMusicName()!=null){
				 fetchedMusic = mr.findAllBymusicName(music.getMusicName());
				 if(fetchedMusic.size()==0){
					 throw new RecordNotFoundException("No record found specific to "+music.getMusicName(), HttpStatus.NOT_FOUND);
				 }else{
					 response = new MusicResponse("SUCCESS","Music List Fetched Successfully","",HttpStatus.FOUND,fetchedMusic);
			}
			}
		}catch(RecordNotFoundException exp){
        	GenericResponse gr = new GenericResponse("FAILED","",exp.getErrorMsg(),exp.getStatusCode());
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.NOT_FOUND);
		}
		catch(Exception e){
			e.printStackTrace();
			response = new GenericResponse("FAILURE","", "UNABLE TO FETCH");
		}
		
		
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
//		List<Music> musicList = new ArrayList<Music>();
//		musicList = mr.findAll();
//		MusicResponse mr = new MusicResponse("SUCCESS", "Music Fetched Successfuly", "", HttpStatus.OK, musicList);
//		return new ResponseEntity<GenericResponse>(mr,HttpStatus.OK);
	}
}
