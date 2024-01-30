package com.example.dem.entities;

import java.util.List;

import jakarta.persistence.*;
@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<Song> s;
	
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playlist(int id, String name, List<Song> s) {
		super();
		this.id = id;
		this.name = name;
		this.s = s;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getS() {
		return s;
	}
	public void setS(List<Song> s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", s=" + s + "]";
	}
	
	
}
