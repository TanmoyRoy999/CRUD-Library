package com.SpringBoot.CRUD.Service;

import java.util.List;

import com.SpringBoot.CRUD.Entities.Book;

public interface RestInterface {
	
	public String homePage();
	public List<Book> getAllBooks();
	public Book getBookById(long id);
	public String addBook(Book book);
	public String updateBook(Book book);
	public String deleteBook(long id);

}
