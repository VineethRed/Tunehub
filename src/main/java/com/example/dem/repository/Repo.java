package com.example.dem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dem.entities.Users;

public interface Repo extends JpaRepository<Users, Integer>{
public Users findByEmail(String email);
}
