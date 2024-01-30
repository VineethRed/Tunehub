package com.example.dem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class NavigationController {
@GetMapping("/login")
public String login() {
    //TODO: process POST request
    
    return "login";
}
@GetMapping("/register")
public String register() {
    //TODO: process POST request
    
    return "register";
}
@GetMapping("/newSong")
public String newSong() {
    //TODO: process POST request
    
    return "newSong";
}


}
