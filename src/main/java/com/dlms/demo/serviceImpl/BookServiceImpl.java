package com.dlms.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlms.demo.entity.Book;
import com.dlms.demo.repository.BookRepository;
import com.dlms.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		return bookRepository.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public void updateBook(Book book, Long id) {
		Book existingBook = bookRepository.findById(id).orElse(null);
		if (existingBook != null) {
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPublisher(book.getPublisher());
			existingBook.setIsbn(book.getIsbn());
			existingBook.setYear(book.getYear());
			existingBook.setAvailable(book.isAvailable());
			bookRepository.save(existingBook);
		}
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> searchBook(Long id) {
		return bookRepository.findAll();
	}

	
	@Override
    public List<Book> searchBooks(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
