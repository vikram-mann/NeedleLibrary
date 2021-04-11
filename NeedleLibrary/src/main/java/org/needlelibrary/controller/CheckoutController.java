package org.needlelibrary.controller;

import java.time.LocalDate;
import java.util.List;

import org.needlelibrary.entity.Checkout;
import org.needlelibrary.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController 
{
	
	@Autowired
	CheckoutService checkoutService;
	
	@RequestMapping(value = "/user/book/{isbn}/checkout", method = RequestMethod.GET)
	public String checkout(@PathVariable String isbn, Authentication auth)
	{
		return checkoutService.checkout(isbn, auth.getName());
	}
	
	
	@RequestMapping(value = "/user/book/{isbn}/return", method = RequestMethod.GET)
	public String returnBook(@PathVariable String isbn, Authentication auth)
	{
		return checkoutService.returnBook(isbn, auth.getName());
	}
	
	@RequestMapping(value = "/librarian/extend-checkout", method = RequestMethod.GET)
	public void extendCheckout(@RequestParam Long id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate due_date)
	{
		checkoutService.extend(id, due_date);
	}
	
	
	@RequestMapping(value = "/librarian/checkouts", method = RequestMethod.GET)
	public List<Checkout> searchCheckouts(@RequestParam(defaultValue = "empty") String userName, 
								@RequestParam(defaultValue = "empty") String isbn)
	{
		if(!userName.equals("empty")) return checkoutService.getCheckoutByUser(userName);
		else if(!isbn.equals("empty")) return checkoutService.getCheckoutByBook(isbn);
		else return checkoutService.getCheckouts();
	}
}
