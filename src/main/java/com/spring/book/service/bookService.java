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
	
	public List<book>getAllBook(){
		return this.list;
	}
	
	public book getBookById(int id){
		book book = list.stream().filter(e->e.getBookID() == id).findFirst().get();
		return book;
	}
	
	public void createBook(book b) {
		list.add(b);
	}
	
	public void deleteBook(int id) {
		list = list.stream().filter(e->e.getBookID() != id).collect(Collectors.toList());
	}
}
