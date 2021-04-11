package org.needlelibrary.controller;

import java.util.List;

import org.needlelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.needlelibrary.entity.User;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	

}
