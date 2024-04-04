package com.spring.book.entities;

public class book {
	private int bookID;
	private String bokName;
	private String author;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public book(int bookID, String bokName, String author) {
		super();
		this.bookID = bookID;
		this.bokName = bokName;
		this.author = author;
	}

	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
