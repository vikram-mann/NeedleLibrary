package org.needlelibrary.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.needlelibrary.entity.Book;
import org.needlelibrary.entity.Checkout;
import org.needlelibrary.repo.BookRepository;
import org.needlelibrary.repo.CheckoutRepository;
import org.needlelibrary.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService 
{
	
	@Autowired
	CheckoutRepository checkoutRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	public String checkout(String isbn, String userName)
	{
		
		Optional<Checkout> checkoutExists = checkoutRepo.findByIsbnAndUserId(isbn, userName);
		if(!checkoutExists.isPresent()) 
		{
			Optional<Book> book = bookRepo.findById(isbn);
			int avail = book.get().getCopies_available();
			if(avail == 0)
			{
				return ("<h1> Book Not available for checkout<h1>");
			}
			else
			{
				book.get().setCopies_available(book.get().getCopies_available() - 1);
				bookRepo.save(book.get());
				
				LocalDate date = LocalDate.now();
				Checkout checkout = new Checkout(userName, isbn, date, date.plusDays(7), null);
				checkoutRepo.save(checkout);
				
				return ("<h1> Book checked out successfully<h1>");
			}
		}
		else return ("<h1> Book already checked out by same user<h1>");
	}
	
	public String returnBook(String isbn, String userName)
	{
		LocalDate return_date = LocalDate.now();
		
		Optional<Checkout> checkout = checkoutRepo.findByIsbnAndUserId(isbn, userName);
		if(checkout.isPresent())
		{
			checkout.get().setReturn_date(return_date);
			checkout.get().setDue_date(null);
			
			checkoutRepo.save(checkout.get());
			
			Optional<Book> book = bookRepo.findById(isbn);
			book.get().setCopies_available(book.get().getCopies_available() + 1);
			bookRepo.save(book.get());
			
			return ("<h1> Book returned successfully <h1>");
		}
		else return ("<h1> Book Not checked out by the user<h1>");
	}

	public List<Checkout> getCheckoutByUser(String userName) {
		
		return checkoutRepo.findByUserId(userName);
	}

	public List<Checkout> getCheckoutByBook(String isbn) {
	
		return checkoutRepo.findByIsbn(isbn);
	}

	public List<Checkout> getCheckouts() {
		return checkoutRepo.findAll();
	}
	
	public void extend(Long id, LocalDate due_date)
	{
		Optional<Checkout> checkout = checkoutRepo.findById(id);
		
		if(checkout.isPresent()) checkout.get().setDue_date(due_date);
		
		checkoutRepo.save(checkout.get());
	}

}
