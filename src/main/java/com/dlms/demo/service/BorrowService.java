package com.dlms.demo.service;


import java.util.Date;
import java.util.List;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Borrow;
import com.dlms.demo.entity.Member;

public interface BorrowService {
	List<Borrow> getBorrowingHistory(Member member);

	List<Borrow> getBooksBorrowed(Book book);

	List<Borrow> getOverdueBorrows(Date date);

	void borrowBook(Member member, Book book);

	void returnBook(Member member, Book book);

	double generateFine(Borrow borrow, Date date);

	void deleteBorrow(Borrow borrow);
}
