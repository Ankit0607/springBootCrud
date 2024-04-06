package com.spring.book.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class book {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int bookID;

	private String bokName;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference // used to avoid the recursion call
	private author author;

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBokName() {
		return bokName;
	}

	public void setBokName(String bokName) {
		this.bokName = bokName;
	}

	public author getAuthor() {
		return author;
	}

	public void setAuthor(author author) {
		this.author = author;
	}

	public book(int bookID, String bokName, author author) {
		super();
		this.bookID = bookID;
		this.bokName = bokName;
		this.author = author;
	}

	public book() {
		super();
	}

}
