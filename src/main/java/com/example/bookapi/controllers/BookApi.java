package com.example.bookapi.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.models.Book;
import com.example.bookapi.services.BookServ;

@RestController
public class BookApi {

//	private final BookServ bookserv;
//	public BooksApi(BookServ BookServ){
//		this.BookServ = BookServ;
//	}

	@Autowired
	private BookServ bookserv;

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {

		Book book = bookserv.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}

	@DeleteMapping(value = "/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookserv.deleteBook(id);
	}

	@GetMapping(value = "/api/books/todos")
	public Book show(@PathVariable("id") Long id) {
		Book libro = bookserv.findBook(id);
		return libro;
	}

	@GetMapping(value = "/api/books/libro/{id}")
	public Iterable<Book> todosLibros() {
		System.out.println(" TODOS LIBROS");
		return bookserv.allBooks();
	}

	
	@PostMapping(value = "api/books/crear")
	public Book createBook(@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, 
			@RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		Book libro = new Book(title, desc, lang, numOfPages);
		return bookserv.createBook(libro);

	}
	
	
	
//	@Override
//	@PostMapping(value = "api/books/crear")
//	public void createBook() {
//		System.out.println();
//
//	}

}
