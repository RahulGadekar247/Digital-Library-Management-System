package com.dlms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlms.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
    List<Book> findByTitleContainingIgnoreCase(String title);
    
    List<Book> findByTitleContaining(String title);

//  @Query ("Select Book from Book where title is Like")
//  List<Book> searchBooks(Long id);
//	List<Book> findByAvailableTrue();
}

