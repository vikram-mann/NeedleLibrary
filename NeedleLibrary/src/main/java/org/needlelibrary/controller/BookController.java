package org.needlelibrary.controller;

import java.util.List;


import org.needlelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.needlelibrary.entity.Book;

@RestController
public class BookController 
{
	
	@Autowired
	BookService bookService;
	
	//Get all the available books
	@RequestMapping(value = "/user/books", method = RequestMethod.GET)
	public List<Book> getBooks(@RequestParam(defaultValue = "empty") String title, 
													@RequestParam(defaultValue = "empty") String authors)
	{
		if(!title.equals("empty")) return bookService.getBookByTitle(title);
		else if(!authors.equals("empty")) return bookService.getBookByAuthors(authors);
		else return bookService.getBooks();
		
		
	}
	
	//Adding a book
	@RequestMapping(value = "/librarian/add-book", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book)
	{
		bookService.addBook(book);
	}
	
	//Discontinuing a book
	@RequestMapping(value = "/librarian/disc-book/{isbn}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable String isbn)
	{
		bookService.deleteBook(isbn);
	}

}
