package com.dlms.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dlms.demo.entity.Book;
import com.dlms.demo.entity.Member;
import com.dlms.demo.entity.Reservation;
import com.dlms.demo.service.BookService;
import com.dlms.demo.service.MemberService;
import com.dlms.demo.service.ReservationService;

@Controller
@RequestMapping("/book-reservation.html")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/reserve")
    public String showReservationForm(Model model) {

        model.addAttribute("members", memberService.getAllMembers());
        return "reservationForm";
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveBook(@RequestParam("bookId") long bookId, @RequestParam("memberId") long memberId, 
                                               @RequestParam("reservationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationDate) {
        Book book = bookService.getBookById(bookId);
        Member member = memberService.getMemberById(memberId);
        Reservation reservation = reservationService.reserveBook(member, book, reservationDate);
        if (reservation != null) {
            return new ResponseEntity<String>("Book has been reserved.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Reservation failed. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable("id") long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        reservationService.cancelReservation(reservation);
        return "redirect:/";
    }
}
