package com.dlms.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Borrow {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;

	private Date borrowDate;

	private Date dueDate;

	private Date returnDate;

	public Borrow() {}

	public Borrow(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void returnBook() {
		this.returnDate = new Date();
	}

	public double generateFine(Date date) {
		if (this.returnDate == null || this.returnDate.before(this.dueDate)) {
			return 0.0;
		} else {
			long diff = this.returnDate.getTime() - this.dueDate.getTime();
			long daysLate = diff / (24 * 60 * 60 * 1000);
			return daysLate * this.book.getFinePerDay();
		}
	}
    
}
