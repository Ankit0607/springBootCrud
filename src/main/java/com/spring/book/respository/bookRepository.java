package com.spring.book.respository;

import org.springframework.data.repository.CrudRepository;

import com.spring.book.entities.book;

public interface bookRepository extends CrudRepository<book, Integer> {
	
	public book findById(int id);

}
