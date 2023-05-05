package com.dlms.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Borrow;
import com.dlms.demo.entity.Member;
import com.dlms.demo.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
	
	@Autowired
	private BorrowService borrowService;
	
	@GetMapping("/history/{memberId}")
	public ResponseEntity<List<Borrow>> getBorrowingHistory(@PathVariable Long memberId) {
		Member member = new Member();
		List<Borrow> history = borrowService.getBorrowingHistory(member);
		return new ResponseEntity<>(history, HttpStatus.OK);
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<List<Borrow>> getBooksBorrowed(@PathVariable Long bookId) {
		Book book = new Book();
		List<Borrow> borrows = borrowService.getBooksBorrowed(book);
		return new ResponseEntity<>(borrows, HttpStatus.OK);
	}
	
	@GetMapping("/overdue/{date}")
	public ResponseEntity<List<Borrow>> getOverdueBorrows(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		List<Borrow> borrows = borrowService.getOverdueBorrows(date);
		return new ResponseEntity<>(borrows, HttpStatus.OK);
	}
	
	@PostMapping("/{memberId}/{bookId}")
	public ResponseEntity<String> borrowBook(@PathVariable Long memberId, @PathVariable Long bookId) {
		Member member = new Member();
		Book book = new Book();
		borrowService.borrowBook(member, book);
		return new ResponseEntity<>("Book borrowed successfully.", HttpStatus.CREATED);
	}
	
	@PutMapping("/{memberId}/{bookId}")
	public ResponseEntity<String> returnBook(@PathVariable Long memberId, @PathVariable Long bookId) {
		Member member = new Member();
		Book book = new Book();
		borrowService.returnBook(member, book);
		return new ResponseEntity<>("Book returned successfully.", HttpStatus.OK);
	}
	
	@GetMapping("/fine/{id}/{date}")
	public ResponseEntity<Double> generateFine(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Borrow borrow = new Borrow(id);
		Double fine = borrowService.generateFine(borrow, date);
		return new ResponseEntity<>(fine, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBorrow(@PathVariable Long id) {
		borrowService.deleteBorrow(new Borrow(id));
		return new ResponseEntity<>("Borrow record deleted successfully.", HttpStatus.OK);
	}
	
	@PostMapping("/{memberId}/{bookId}/{date}")
	public ResponseEntity<String> borrowBook(@PathVariable Long memberId, @PathVariable Long bookId, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
	    Member member = new Member();
	    Book book = new Book();
	    borrowService.borrowBook(member, book);
	    return new ResponseEntity<>("Book borrowed successfully.", HttpStatus.CREATED);
	}

	
}
