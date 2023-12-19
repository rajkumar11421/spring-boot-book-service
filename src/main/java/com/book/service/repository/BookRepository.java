package com.book.service.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.service.entity.Book;

// Spring Data JPA creates CRUD implementation at runtime automatically.
@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

  // it works if it matches the book field name
  List<Book> findByTitle(String title);
  Optional<Book> findById(Long id);
  void deleteById(Long id);

  // Custom Query
  @Query("SELECT b FROM Book b WHERE b.publishDate > :date")
  List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);

}