package com.example.dem.services;

import java.util.List;

import com.example.dem.entities.Playlist;

public interface PlayListService {

	void addPlayList(Playlist play);
	List<Playlist>  fetchAll();
	

}
