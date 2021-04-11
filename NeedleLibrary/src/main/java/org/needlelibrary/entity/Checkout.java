package org.needlelibrary.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkout")
public class Checkout 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkout_id")
	private Long id;
	@Column(name = "user_id")
	private String userId;
    private String isbn;
    private LocalDate checkout_date;
    private LocalDate due_date;
    private LocalDate return_date;
    
    public Checkout() {};
    
	public Checkout(String user_id, String isbn, LocalDate checkout_date, LocalDate due_date,
			LocalDate return_date) 
	{
		this.userId = user_id;
		this.isbn = isbn;
		this.checkout_date = checkout_date;
		this.due_date = due_date;
		this.return_date = return_date;
	}

	

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(LocalDate checkout_date) {
		this.checkout_date = checkout_date;
	}

	public LocalDate getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	
	

}
