package org.needlelibrary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home()
	{
		return ("<h1> WElcome home!!! <h1>");
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user()
	{
		return ("<h1> WElcome User!!! <h1>");
	}
	
	@RequestMapping(value = "/librarian", method = RequestMethod.GET)
	public String librarian()
	{
		return ("<h1> WElcome Librarian!!! <h1>");
	}

	

}
