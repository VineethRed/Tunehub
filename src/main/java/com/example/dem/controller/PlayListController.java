package com.example.dem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.dem.entities.Playlist;
import com.example.dem.entities.Song;
import com.example.dem.services.PlayListService;
import com.example.dem.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PlayListController {
	@Autowired
SongService s;
	@Autowired
	PlayListService p;
	@GetMapping("/createPlayList")
	public String addPlayList(Model m) {
	    //TODO: process POST request
		List<Song> ss =s.fetchAll();
		m.addAttribute("songs", ss);
	    return "createPlayList";
	}
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute Playlist play) {
		//TODO: process POST request
		p.addPlayList(play);
		System.out.println(play);
		List<Song> song=play.getS();
		for(Song ss:song)
		{
			ss.getPl().add(play);
			s.updateSong(ss);
		}
		return "adminhome";
	}
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model m) {
		List<Playlist> pl=p.fetchAll();
		m.addAttribute("play", pl);
		return "viewPlayList";
	}
	
	

}
