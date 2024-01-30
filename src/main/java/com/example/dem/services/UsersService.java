package com.example.dem.services;

import com.example.dem.entities.Users;

public interface UsersService {
	String addUser(Users user);
	boolean emailExists(String email);
	boolean validateUser(String email,String password);
	String getUserRole(String email);
	Users getUser(String email);
	void updateUser(Users u);
}
