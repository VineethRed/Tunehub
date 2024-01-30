package com.example.dem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dem.entities.Song;
import com.example.dem.services.SongServiceImplementation;

@Controller
public class SongController {
	@Autowired
	SongServiceImplementation s;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		//TODO: process POST request
		boolean b=s.songExists(song.getName());
		if(b==false)
		{
		s.addSong(song);
		return "adminhome";
		}
		else
		{
		return "newSong";
		}
	}
	@GetMapping("/viewSong")
	public String viewSong(Model m) {
		//TODO: process POST request
		List<Song> ss =s.fetchAll();
		m.addAttribute("songs", ss);
		
		return "displaySong";
	}
	@GetMapping("/playSong")
	public String playSong(Model m) {
		//TODO: process POST request
		boolean pay=false;
		if(pay==true)
		{
		List<Song> ss =s.fetchAll();
		m.addAttribute("songs", ss);
		
		return "displaySong";
		}
		else
		{
			return "makePayment";
		}
	}
	

}
