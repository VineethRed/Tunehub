package com.example.dem.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dem.entities.Playlist;
import com.example.dem.repository.PlayListRepo;
@Service
public class PlayListImplementation implements PlayListService{
	@Autowired
PlayListRepo pr;
	@Override
	public void addPlayList(Playlist play) {
		// TODO Auto-generated method stub
		pr.save(play);	
	}
	@Override
	public List<Playlist> fetchAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}
}
