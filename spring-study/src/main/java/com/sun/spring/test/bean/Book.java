package com.sun.spring.test.bean;

public class Book {

	private String name;

	private BookLabel bookLabel;

	public Book(String name){
		this.name = name;
	}

	public Book(BookLabel bookLabel){
		this.bookLabel = bookLabel;
	}

	public BookLabel getBookLabel() {
		return bookLabel;
	}

	public void setBookLabel(BookLabel bookLabel) {
		this.bookLabel = bookLabel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
