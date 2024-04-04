package com.spring.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.book.entities.book;
import com.spring.book.service.bookService;

@RestController
public class bookController {

	@Autowired
	bookService bookService;

	// Get all the book
	@GetMapping("/books")
	public ResponseEntity<List<book>> getAllBook() {

		List<book> list = bookService.getAllBook();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(list));

	}

	// Get single book by Id
	@GetMapping("/books/{id}")
	public ResponseEntity<book> getBookById(@PathVariable("id") int id) {
		book book = bookService.getBookById(id);
		if (book == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(book));
	}

	// Add a new book
	@PostMapping("/books")
	public ResponseEntity<book> addBook(@RequestBody book b) {
		try {
			bookService.createBook(b);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();

		} catch (Exception e) {

		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// Delete an existing book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// Update an existing book
	@PutMapping("/books/{id}")
	public ResponseEntity<book> updateBook(@RequestBody book book, @PathVariable("id") int id) {
		try {
			book bk = bookService.updateBook(book, id);
			if (bk == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
