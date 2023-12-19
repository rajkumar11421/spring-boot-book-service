package com.book.service.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.entity.Book;
import com.book.service.repository.BookRepository;

@CrossOrigin("*")
@RestController
public class BookController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/createBooks", method = RequestMethod.POST, produces = { "application/json" })
	public void createBooks(@RequestBody Book book) {
		
        bookRepository.save(book);
	}
	
	@RequestMapping(value="/getBooks", method = RequestMethod.GET, produces = { "application/json" })
	public List<Book> getBooks() {
        return bookRepository.findAll();
	}
	
	@RequestMapping(value="/getBook/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public Book getBook(@PathVariable long id) {
        return bookRepository.findById(id).get();
	}
	
	@RequestMapping(value="/updateBook/{id}", method = RequestMethod.PUT)
	public void updateBook(@PathVariable long id, @RequestBody Book book) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
	        Book  bookEntity = optionalBook.get();
	        bookEntity.setPrice(book.getPrice());
	        bookEntity.setTitle(book.getTitle());
	        bookRepository.save(bookEntity);
		}
	}

	@RequestMapping(value="/deleteBook/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
	}
}

