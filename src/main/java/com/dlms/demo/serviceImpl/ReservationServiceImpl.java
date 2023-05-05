package com.dlms.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Member;
import com.dlms.demo.entity.Reservation;
import com.dlms.demo.repository.ReservationRepository;
import com.dlms.demo.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
    
	@Autowired
	private final ReservationRepository reservationRepository;


	public ReservationServiceImpl(ReservationRepository reservationRepository) {
	    this.reservationRepository = reservationRepository;
	}

	@Override
	public Reservation getReservation(Member member, Book book) {
	    return reservationRepository.findByBookAndMember(book, member);
	}

	@Override
	public List<Reservation> getReservationsByBook(Book book) {
	    return reservationRepository.findByBook(book);
	}

	@Override
	public List<Reservation> getReservationsByMember(Member member) {
	    return reservationRepository.findByMember(member);
	}

	@Override
	public Reservation reserveBook(Book book, Member member) {
	    Reservation reservation = new Reservation();
	    return reservationRepository.save(reservation);
	}

	@Override
	public void cancelReservation(Reservation reservation) {
	    reservationRepository.delete(reservation);
	}

	@Override
	public Reservation reserveBook(Member member, Book book, Date reservationDate) {
	    Reservation reservation = new Reservation();
	    return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservationById(long reservationId) {
	    return reservationRepository.findById(reservationId).orElse(null);
	}
}

