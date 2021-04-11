package org.needlelibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.needlelibrary.entity.Book;
import org.needlelibrary.repo.BookRepository;

@Service
public class BookService 
{
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getBooks()
	{
		return bookRepo.findAll();
	}

	public List<Book> getBookByTitle(String title) 
	{
		return bookRepo.findByTitleContaining(title);
		
	}
	
	public List<Book> getBookByAuthors(String authors) 
	{
		return bookRepo.findByAuthorsContaining(authors);
		
	}
	
	public void addBook(Book book)
	{
		bookRepo.save(book);
	}
	
	
	public void deleteBook(String isbn)
	{
		bookRepo.deleteById(isbn);
	}
	
}
