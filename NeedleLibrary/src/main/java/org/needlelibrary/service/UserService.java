package org.needlelibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.needlelibrary.entity.User;
import org.needlelibrary.repo.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository userRepo;

	public List<User> getUsers() {
		
		return userRepo.findAll();
	}

}
