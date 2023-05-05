package com.dlms.demo.service;

import java.util.List;

import com.dlms.demo.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    List<Book> searchBook(Long id);
	List<Book> searchBooksByTitle(String title);
	void addBook(Book book);
	
	void updateBook(Book book, Long Id);
//	List<Book> getAllAvailableBooks();
	List<Book> searchBooks(String title);
	
}
