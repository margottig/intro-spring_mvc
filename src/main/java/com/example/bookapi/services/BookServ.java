package com.example.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookapi.models.Book;
import com.example.bookapi.repositories.BookRepo;

@Service
public class BookServ {

	// Agregando el book al repositorio como una dependencia
//	private final BookRepo bookrepo;
//	
//	public BookServ(BookRepo bookRepo) {
//		this.bookrepo = bookRepo;
//	}

	@Autowired
	private BookRepo bookrepo;

	// Devolviendo todos los libros.
	public Iterable<Book> allBooks() {
		Iterable<Book> todoslibros = bookrepo.findAll();
		return todoslibros;
//		return bookrepo.findAll();
	}

	// Creando un libro.
	public Book createBook(Book b) {
		return bookrepo.save(b);
	}

	// Obteniendo la información de un libro
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookrepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}


	public Book updateBook(Long id, String title, String desc, String lang, int pages) {
		Optional<Book> optionalBook = bookrepo.findById(id);
		if (optionalBook.isPresent()) {
			Book bookToUpdate = optionalBook.get();
			bookToUpdate.setTitle(title);
			bookToUpdate.setDescription(desc);
			bookToUpdate.setLanguage(lang);
			bookToUpdate.setNumberOfPages(pages);
			bookrepo.save(bookToUpdate);
			return bookToUpdate;
		} else {
			return null;
		}
	}

	public Book updateBook2(Long id, String title, String desc, String lang, int pages) {
		Book optionalBook = bookrepo.findById(id).orElse(null);
		if (optionalBook != null) {
			optionalBook.setTitle(title);
			optionalBook.setDescription(desc);
			optionalBook.setLanguage(lang);
			optionalBook.setNumberOfPages(pages);
			bookrepo.save(optionalBook);
			return optionalBook;
		} else {
			return optionalBook;
		}
	}
	
	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
	}

}
