package com.example.dem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dem.entities.Playlist;

public interface PlayListRepo extends JpaRepository<Playlist,Integer>{

}
