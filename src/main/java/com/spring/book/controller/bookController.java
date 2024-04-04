package com.spring.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.book.entities.book;

@RestController
public class bookController {

	@Autowired
	com.spring.book.service.bookService bookService;

	@GetMapping("/books")
	public List<book> getAllBook() {
		return bookService.getAllBook();

	}

	@GetMapping("/books/{id}")
	public book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public book addBook( @RequestBody book  b) {
		bookService.createBook(b);
		return b;
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookService.deleteBook(id);
		return "Book deleted";
		
	}
}
