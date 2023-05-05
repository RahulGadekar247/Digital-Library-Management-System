package com.dlms.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Borrow;
import com.dlms.demo.entity.Member;
import com.dlms.demo.repository.BorrowRepository;
import com.dlms.demo.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {
    
	@Autowired
	private final BorrowRepository borrowRepository;

  
    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public List<Borrow> getBorrowingHistory(Member member) {
        return borrowRepository.findByMember(member);
    }

    @Override
    public List<Borrow> getBooksBorrowed(Book book) {
        return borrowRepository.findByBook(book);
    }

    @Override
    public List<Borrow> getOverdueBorrows(Date date) {
        return borrowRepository.findByReturnDateIsNullAndDueDateBefore(date);
    }

    @Override
    public void borrowBook(Member member, Book book) {
        Borrow borrow = new Borrow();
        borrowRepository.save(borrow);
    }

    @Override
    public void returnBook(Member member, Book book) {
        Borrow borrow = borrowRepository.findByMemberAndBookAndReturnDateIsNull(member, book);
        if (borrow != null) {
            borrow.returnBook();
            borrowRepository.save(borrow);
        }
    }

    @Override
    public double generateFine(Borrow borrow, Date date) {
        return borrow.generateFine(date);
    }

	@Override
	public void deleteBorrow(Borrow borrow) {
		
		borrowRepository.delete(borrow);
		
	}
}
