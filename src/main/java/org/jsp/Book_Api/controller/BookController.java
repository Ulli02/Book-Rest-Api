package org.jsp.Book_Api.controller;

import java.util.List;

import org.jsp.Book_Api.dto.Book;
import org.jsp.Book_Api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService service;

	@PostMapping("/books")
	public ResponseEntity<Object> saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}

	@PostMapping("/books/many")
	public ResponseEntity<Object> saveBooks(@RequestBody List<Book> book) {
		return service.saveBooks(book);
	}

	// Fetch Book By Id
	@GetMapping("/books")
	public ResponseEntity<Object> fetchAll() {
		return service.fetchAll();
	}

	// Fetch Book By Id
	@GetMapping("/books/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id) {
		return service.fetchById(id);
	}

	// Fetch Book By Title
	@GetMapping("/books/title/{title}")
	public ResponseEntity<Object> fetchByTitle(@PathVariable String title) {
		return service.fetchByTitle(title);
	}

	// Fetch Book By Author
	@GetMapping("/books/author/{author}")
	public ResponseEntity<Object> fetchByAuthor(@PathVariable String author) {
		return service.fetchByAuthor(author);
	}

	// Delete Book By Id
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	// Update Book - PUT
	@PutMapping("/books")
	public ResponseEntity<Object> updateRecord(@RequestBody Book book) {
		return service.updateBook(book);
	}

	// Update Book - PATCH
	@PatchMapping("/books/{id}")
	public ResponseEntity<Object> updateRecord(@PathVariable int id, @RequestBody Book book) {
		return service.updateBook(id, book);
	}

}
