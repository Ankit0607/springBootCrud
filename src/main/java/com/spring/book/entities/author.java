package com.spring.book.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author")
public class author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private String language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public author(int id, String firstName, String lastName, String language) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}

	public author() {
		super();
	}

	@Override
	public String toString() {
		return "author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", language=" + language
				+ "]";
	}

}
