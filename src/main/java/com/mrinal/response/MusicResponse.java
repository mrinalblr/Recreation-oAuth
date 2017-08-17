package com.mrinal.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.mrinal.model.Music;

public class MusicResponse extends GenericResponse{

	private List<Music> musicList;

	public MusicResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}

	public MusicResponse(String status, String successMessage, String errorMessage, HttpStatus statusCode,
			List<Music> musicList) {
		super(status, successMessage, errorMessage, statusCode);
		this.musicList = musicList;
	}

	
	
}
