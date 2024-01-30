package com.example.dem.services;

import java.util.List;

import com.example.dem.entities.Song;

public interface SongService {
void addSong(Song song);
public List<Song> fetchAll();
public boolean songExists(String name);
void updateSong(Song s);
}
