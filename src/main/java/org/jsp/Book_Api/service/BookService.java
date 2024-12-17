package org.jsp.Book_Api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jsp.Book_Api.dto.Book;
import org.jsp.Book_Api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public ResponseEntity<Object> saveBook(Book book) {
		repository.save(book);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Book Added Success");
		map.put("data", book);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ResponseEntity<Object> saveBooks(List<Book> book) {
		repository.saveAll(book);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Books Added Sucess");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ResponseEntity<Object> fetchAll() {
		List<Book> list = repository.findAll();
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Books Not Found");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Books Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchById(int id) {
		Optional<Book> optional = repository.findById(id);
		if (optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Not Found with Id: " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Found");
			map.put("data", optional.get());
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByTitle(String title) {
		List<Book> list = repository.findByTitle(title);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Not Found with Title: " + title);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByAuthor(String author) {
		List<Book> list = repository.findByAuthor(author);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Not Found with Author Name: " + author);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> deleteById(int id) {
		Optional<Book> optional = repository.findById(id);
		if (optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Not Found with Id: " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			repository.deleteById(id);
			map.put("message", "Deleted Book Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> updateBook(Book book) {
		repository.save(book);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Book Updated Success");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ResponseEntity<Object> updateBook(int id, Book book) {
		Optional<Book> optional = repository.findById(id);
		if (optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Book Not Found with Id: " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			Book existingBook = optional.get();
			if (book.getId() != 0)
				existingBook.setId(book.getId());
			if (book.getAuthor() != null)
				existingBook.setAuthor(book.getAuthor());
			if (book.getTitle() != null)
				existingBook.setTitle(book.getTitle());
			repository.save(existingBook);
			map.put("message", "Book Updated Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

}
