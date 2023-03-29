package com.SpringBoot.CRUD.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.CRUD.Dao.DaoInterface;
import com.SpringBoot.CRUD.Entities.Book;

@Service
public class RestInterfaceImplementation implements RestInterface{
	
	@Autowired
	private DaoInterface dao;
//	private List<Book> library;
	
	public RestInterfaceImplementation() {
//		this.library = new ArrayList<>();
//		library.add(new Book(1,"Think like a monk","Jay Shetty"));
//		library.add(new Book(2,"Atomic Habits","James Clear"));
//		library.add(new Book(3,"Doglapan","Ashneer Grover"));
	}

	@Override
	public String homePage() {
		return "Welcome to Tanmoy's Library";
	}
	
	@Override
	public List<Book> getAllBooks() {
//		return library;
		return dao.findAll();
	}

	@Override
	public Book getBookById(long id) {
//		for (Book book:library) {
//			if (book.getId()==id) {
//				return book;
//			}
//			
//		}
//		return null; 
//		return dao.getOne(id);
		return dao.findById(id).get();
	}

	@Override
	public String addBook(Book book) {
//		if (library.contains(book)) {
//			return "Book already there!";
//		}
//		library.add(book);
		dao.save(book);
		return "Added "+book;
		
	}

	@Override
	public String updateBook(Book book) {
		dao.save(book);
		return "Updated "+book;
	}

	@Override
	public String deleteBook(long id) {
		dao.delete(dao.getReferenceById(id));
		return "Deleted";
	}
}

