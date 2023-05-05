package com.dlms.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Borrow;
import com.dlms.demo.entity.Member;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	List<Borrow> findByMember(Member member);

	List<Borrow> findByBook(Book book);

	List<Borrow> findByReturnDateIsNullAndDueDateBefore(Date date);

	Borrow findByMemberAndBookAndReturnDateIsNull(Member member, Book book);

}
