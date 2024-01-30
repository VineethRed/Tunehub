package com.example.dem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dem.entities.Song;

public interface SongRepo extends JpaRepository<Song, Integer>{

	Song findByName(String name);

}
