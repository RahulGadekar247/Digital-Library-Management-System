package com.dlms.demo.service;

import java.util.Date;
import java.util.List;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Member;
import com.dlms.demo.entity.Reservation;


public interface ReservationService {
    Reservation reserveBook(Book book, Member member);
    void cancelReservation(Reservation reservation);
	Reservation getReservation(Member member, Book book);
	List<Reservation> getReservationsByBook(Book book);
	List<Reservation> getReservationsByMember(Member member);
	Reservation reserveBook(Member member, Book book, Date reservationDate);
	Reservation getReservationById(long reservationId);
}
