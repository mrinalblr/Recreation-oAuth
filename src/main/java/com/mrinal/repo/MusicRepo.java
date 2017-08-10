package com.mrinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrinal.model.Music;

public interface MusicRepo extends JpaRepository<Music, Integer> {

}
