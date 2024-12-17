package org.jsp.Book_Api.repository;

import java.util.List;

import org.jsp.Book_Api.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);


}
