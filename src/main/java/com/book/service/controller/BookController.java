package com.book.service.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.entity.Book;
import com.book.service.repository.BookRepository;

@RestController
public class BookController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/createBooks", method = RequestMethod.GET, produces = { "application/json" })
	public void createBooks() {
		
		Book b1 = new Book("Book A", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31));
        Book b2 = new Book("Book B", BigDecimal.valueOf(19.99), LocalDate.of(2023, 7, 31));
        Book b3 = new Book("Book C", BigDecimal.valueOf(29.99), LocalDate.of(2023, 6, 10));
        Book b4 = new Book("Book D", BigDecimal.valueOf(39.99), LocalDate.of(2023, 5, 5));
        
        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);
        bookRepository.save(b4);
	}
	
	@RequestMapping(value="/getBooks", method = RequestMethod.GET, produces = { "application/json" })
	public List<Book> getBooks() {
        return bookRepository.findAll();
	}
}
