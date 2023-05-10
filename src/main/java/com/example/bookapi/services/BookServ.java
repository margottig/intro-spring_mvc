package com.example.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookapi.models.Book;
import com.example.bookapi.repositories.BookRepo;

@Service
public class BookServ {

	//Agregando el book al repositorio como una dependencia
//	private final BookRepo bookrepo;
//	
//	public BookServ(BookRepo bookRepo) {
//		this.bookrepo = bookRepo;
//	}
	
	@Autowired
	private BookRepo bookrepo;
	
	
	//Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookrepo.findAll();
	}
	//Creando un libro.
	public Book createBook(Book b) {
		return bookrepo.save(b);
	}
	//Obteniendo la información de un libro
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookrepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
