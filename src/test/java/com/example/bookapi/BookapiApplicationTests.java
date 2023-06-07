package com.example.bookapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bookapi.controllers.BookController;
import com.example.bookapi.models.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest
class BookapiApplicationTests {
	@Autowired
	private BookController controller;
	@Autowired
	private MockMvc mockMvc;
	
	private static Validator validator;
	
	@BeforeAll
	static void setUp() {
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	}
	

	@Test
	void contextLoads() {
	}

	@Test
    void testController() {
        assertThat(controller).isNotNull();
    }
	
	@Test
	void assumeTitleIsNull() {
		Book book = new Book();
		book.setDescription("Great Book");
		book.setLanguage("English");
		book.setNumberOfPages(null);
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    assertFalse(violations.isEmpty());
	}
	
	@Test
	void testLibro() {
		Book book = new Book();
		book.setTitle("Mi planta de naranja lima");
		book.setDescription("Great Book");
		book.setLanguage("Spanish");
		book.setNumberOfPages(null);
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		
		for(ConstraintViolation<Book> violation : violations) {
			System.out.println(violation.getMessage());
		}
	    assertTrue(violations.isEmpty());
	}
	
//	@Test
//	public void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("Hello, World")));
//	}
}
