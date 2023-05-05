package com.dlms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Member;
import com.dlms.demo.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByBookAndMember(Book book, Member member);
    List<Reservation> findByBook(Book book);
    List<Reservation> findByMember(Member member);
}
