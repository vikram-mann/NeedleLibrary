package org.needlelibrary.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book 
{
	@Id
	private String isbn;
	private String title;
	private String authors;
	private String genre;
	private int copies_available;
	private int total_copies;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getCopies_available() {
		return copies_available;
	}
	public void setCopies_available(int copies_available) {
		this.copies_available = copies_available;
	}
	public int getTotal_copies() {
		return total_copies;
	}
	public void setTotal_copies(int total_copies) {
		this.total_copies = total_copies;
	}

	
	
}
