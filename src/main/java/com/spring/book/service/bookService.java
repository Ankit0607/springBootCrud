package com.spring.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spring.book.entities.book;

@Component
public class bookService {
	static List<com.spring.book.entities.book> list = new ArrayList<>();
	static {
		list.add(new book(12, "Java", "Durgesh"));
		list.add(new book(11, "C++", "Krishna"));
		list.add(new book(10, "Python", "Ankit"));
	}

	// Get all the books
	public List<book> getAllBook() {
		return this.list;
	}

	// Get single book by Id
	public book getBookById(int id) {
		book book = null;
		try {
			book = list.stream().filter(e -> e.getBookID() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Add a new book
	public void createBook(book b) {
		list.add(b);
	}

	// delete an existing book
	public void deleteBook(int id) {
		list = list.stream().filter(e -> e.getBookID() != id).collect(Collectors.toList());
	}

	// updating the existing book detail
	public void updateBook(book book, int id) {
		list = list.stream().map(e -> {
			if (e.getBookID() == id) {
				e.setBokName(book.getBokName());
				e.setAuthor(book.getAuthor());
			}
			return e;
		}).collect(Collectors.toList());
	}
}
