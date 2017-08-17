package com.mrinal.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrinal.model.Music;
import com.mrinal.model.Sports;

public interface MusicRepo extends JpaRepository<Music, Integer> {
	
	public ArrayList<Music>findAllBymusicName(String musicName);
}
