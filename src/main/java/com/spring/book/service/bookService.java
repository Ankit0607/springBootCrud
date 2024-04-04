package com.spring.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.book.entities.book;
import com.spring.book.respository.bookRepository;

@Component
public class bookService {

	@Autowired
	bookRepository bookRepo;

	// Get all the books
	public List<book> getAllBook() {
		List<book> list = (List<book>) this.bookRepo.findAll();
		return list;
	}

	// Get single book by Id
	public book getBookById(int id) {
		book book = null;
		try {

			book = this.bookRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Add a new book
	public void createBook(book b) {
		this.bookRepo.save(b);
	}

	// delete an existing book
	public void deleteBook(int id) {
		this.bookRepo.deleteById(id);
	}

	// updating the existing book detail
	public book updateBook(book book, int id) {
		if (bookRepo.count() != 0) {
			book.setBookID(id);
			this.bookRepo.save(book);
			return book;
		}
		return null;
	}

	/*
	 * This was used when we were using the static data
	 * 
	 * 
	 * static List<com.spring.book.entities.book> list = new ArrayList<>(); static {
	 * list.add(new book(12, "Java", "Durgesh")); list.add(new book(11, "C++",
	 * "Krishna")); list.add(new book(10, "Python", "Ankit")); }
	 * 
	 * // Get all the books public List<book> getAllBook() { return this.list; }
	 * 
	 * // Get single book by Id public book getBookById(int id) { book book = null;
	 * try { book = list.stream().filter(e -> e.getBookID() ==
	 * id).findFirst().get(); } catch (Exception e) { e.printStackTrace(); } return
	 * book; }
	 * 
	 * // Add a new book public void createBook(book b) { list.add(b); }
	 * 
	 * // delete an existing book public void deleteBook(int id) { list =
	 * list.stream().filter(e -> e.getBookID() != id).collect(Collectors.toList());
	 * }
	 * 
	 * // updating the existing book detail public void updateBook(book book, int
	 * id) { list = list.stream().map(e -> { if (e.getBookID() == id) {
	 * e.setBokName(book.getBokName()); e.setAuthor(book.getAuthor()); } return e;
	 * }).collect(Collectors.toList()); }
	 */
}
