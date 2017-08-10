package com.mrinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.model.Music;
import com.mrinal.response.GenericResponse;
import com.mrinal.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

	@Autowired
	MusicService ms;
	
	@RequestMapping(value="/addMusic",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GenericResponse> addMusicActivity(@RequestBody Music music){
		 
		
		return ms.addMusicActivity(music);
		 
	}
	
	
	
}
