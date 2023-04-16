package com.SpringBoot.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.CRUD.Entities.Book;
import com.SpringBoot.CRUD.Service.RestInterface;

@RestController
public class CrudController {

	RestInterface r;

	@Autowired
	public CrudController(RestInterface r) {
		this.r = r;
	}

	@GetMapping
	public String homePage() {
		return r.homePage();
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return r.getAllBooks();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookById(@PathVariable String bookId) {
		return r.getBookById(Long.parseLong(bookId));
	}
	
	/** 
	 * alternate version of getBookById method
	 * http://localhost:8080/books?id=3
	 * by default, it will fetch book with id=2
	 *
	 * @GetMapping("/books")
	 * public Book getBookById(@RequestParam(value="id",defaultValue = "2") String bookId) {
	 * 	return r.getBookById(Long.parseLong(bookId));
	 * }
	 * 
	 */
	
	@PostMapping("/books")
	public String addBook(@RequestBody Book book) {
		return r.addBook(book);
	}
		
	@PutMapping("/books")
	public String updateBook(@RequestBody Book book) {
		return r.updateBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookId) {
		String str;
		try {
			str=r.deleteBook(Long.parseLong(bookId));
//			System.out.println(str);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
