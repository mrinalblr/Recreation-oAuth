package com.mrinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrinal.model.Music;
import com.mrinal.repo.MusicRepo;
import com.mrinal.response.GenericResponse;

@Service
public class MusicService {

	@Autowired
	MusicRepo mr;
	
    @Autowired
    Music musicAct;
    
    
	public ResponseEntity<GenericResponse> addMusicActivity(Music music){
		
		musicAct.setMusicName(music.getMusicName());
		System.out.println("Test : "+musicAct.getMusicName());
		return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS","","",HttpStatus.OK),HttpStatus.OK);
	}
}
