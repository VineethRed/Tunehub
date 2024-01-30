package com.example.dem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.dem.entities.Users;
import com.example.dem.services.UserServicImplementation;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {
	@Autowired
	UserServicImplementation s;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean b=s.emailExists(user.getEmail());
		if(b==false)
		{
		s.addUser(user);
		}
		
		return "page";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession h1) 
	{
		
		//TODO: process POST request
		boolean d=s.validateUser(email,password);
		boolean isPremium=s.isPremium(email);
		String role=s.getUserRole(email);
		if(d==true)
		{
			h1.setAttribute("email", email);
			if(role.equals("admin"))
			{
			return "adminhome";
			}
			else
			{
				if(isPremium)
				{
				  return "displaySong";
				}
				else
				{
				return "customerhome";
				}
			}
		}
		else
		{
		return "login";
	}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "login";
	}
	
	
	
}