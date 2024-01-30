package com.example.dem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dem.entities.Song;
import com.example.dem.repository.SongRepo;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
SongRepo s;
	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		s.save(song);
		
	}
	public List<Song> fetchAll() {
		
		return s.findAll();
	}
	public boolean songExists(String name) {
		// TODO Auto-generated method stub
		Song ss=s.findByName(name);
		if(ss!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	@Override
	public void updateSong(Song ss) {
		// TODO Auto-generated method stub
		s.save(ss);
		
	}

}
