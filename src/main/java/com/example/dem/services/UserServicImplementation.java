package com.example.dem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dem.entities.Users;
import com.example.dem.repository.Repo;


@Service
public class UserServicImplementation implements UsersService{
	@Autowired
	Repo r;
	
	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		r.save(user);
		return null;
	}

	@Override
	public boolean emailExists(String email) {
	if(r.findByEmail(email)==null) {
		return false;
	}
	else
	{
		return true;
	}

}

	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		Users us=r.findByEmail(email);
		if(password.equals(us.getPassword()))
		{
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String getUserRole(String email) {
		Users us=r.findByEmail(email);
		
		return us.getRole();
	}

	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return r.findByEmail(email);
	}

	@Override
	public void updateUser(Users u) {
		// TODO Auto-generated method stub
		r.save(u);
		
	}

	public boolean isPremium(String email) {
		// TODO Auto-generated method stub
		Users u=r.findByEmail(email);
		boolean s=u.isPremium();
		return s;
	}

	
}
