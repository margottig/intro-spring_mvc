package com.example.bookapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.bookapi.models.Book;
import com.example.bookapi.services.BookServ;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookServ bookserv;

	@GetMapping("/")
	public String raiz() {
		return "redirect:/books";
	}

	@GetMapping("/books")
	public String index(Model viewModel) {
//		List<Book> libros = bookserv.allBooks();
//		viewModel.addAttribute("libros", libros);
		viewModel.addAttribute("libros", bookserv.allBooks());
		return "index.jsp";
	}

	@GetMapping("/books/new")
	public String nuevoLibro(@ModelAttribute("book") Book book) {
		return "nuevo.jsp";
	}

	@PostMapping("/books/new")
	public String crearLibro(@Valid @ModelAttribute("book") Book book, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "nuevo.jsp";
		} else {

			bookserv.createBook(book);
			return "redirect:/books";

		}
	}

	@GetMapping("/books/{bookId}")
	public String mostrarLibro(Model viewModel, @PathVariable("bookId") Long bookId) {
		viewModel.addAttribute("libro", bookserv.findBook(bookId));
		return "mostrar.jsp";
	}

	@GetMapping("/books/edit/{bookId}")
	public String formualrioEdicion(@ModelAttribute("libro") Book libro, 
			@PathVariable("bookId") Long bookId,
			Model viewModel) {
		Book unlibro = bookserv.findBook(bookId);
		viewModel.addAttribute("unlibro", unlibro);
		return "editar.jsp";
	}

	@PutMapping("/books/edit/{bookId}")
	public String editarLibro(@ModelAttribute("libro") Book libro, 
			@PathVariable("bookId") Long bookId, Model viewModel,
			BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "editar.jsp";
		} else {
			bookserv.updateBook(libro);
			return "redirect:/books";

		}
		
	}
	
	@GetMapping("/books/delete/{bookId}")
	public String eliminarLibro(@PathVariable("bookId") Long bookId) {
//		Book unlibro = bookserv.findBook(bookId);
		bookserv.deleteBook(bookId);
		return "redirect:/books";
	}
}
