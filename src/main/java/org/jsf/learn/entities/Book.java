package org.jsf.learn.entities;

import java.io.Serializable;



public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2103318926408322381L;
	private String isbn;
	private String title;
	private String author;

	public Book() {
		super();
	}

	public Book(String author, String ISBN, String title) {
		this();
		this.author = author;
		this.isbn = ISBN;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", isbn=" + isbn + ", title=" + title
				+ "]";
	}
}
