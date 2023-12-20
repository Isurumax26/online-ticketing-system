package com.isuru.ticketing_system.controller;

import com.isuru.ticketing_system.model.BookingOrder;
//import com.isuru.ticketing_system.model.UserBooking;
import com.isuru.ticketing_system.model.UserBooking;
import com.isuru.ticketing_system.repository.dao.Booking;
import com.isuru.ticketing_system.repository.dao.Ticket;
import com.isuru.ticketing_system.services.BookingService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/online-ticketing")
@RestController
public class TicketController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = bookingService.getAllTickets();
        return  new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping("/{userId}/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewBooking(@PathVariable Long userId, HttpSession session) {
        @SuppressWarnings("unchecked") List<BookingOrder> bookingOrders = (List<BookingOrder>) session.getAttribute("bookingOrders");
        boolean status = bookingService.createBooking(userId, bookingOrders);
        session.removeAttribute("bookingOrders");
    }

    @PostMapping("/{userId}/bookings/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTicketToBooking(@RequestBody BookingOrder bookingOrder, @PathVariable Long userId, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("bookingOrders") != null) {
            @SuppressWarnings("unchecked") List<BookingOrder> bookingOrders = (List<BookingOrder>) session.getAttribute("bookingOrders");
            bookingOrders.add(bookingOrder);
        }
        else {
            List<BookingOrder> bookingOrders = new ArrayList<>();
            bookingOrders.add(bookingOrder);
            session.setAttribute("bookingOrders", bookingOrders);
        }

    }


    @GetMapping("/{userId}/bookings")
    public ResponseEntity<UserBooking> getUserBookings(@PathVariable Long userId) {
        UserBooking userBooking = bookingService.getAllUserBookings(userId);
        return new ResponseEntity<>(userBooking, HttpStatus.OK);
    }

    @GetMapping("/{userId}/bookings/{bookingId}")
    public ResponseEntity<UserBooking> getUserBookingById(@PathVariable Long userId, @PathVariable Long bookingId) {
        UserBooking userBooking = bookingService.getUserBookingById(userId, bookingId);
        return new ResponseEntity<>(userBooking, HttpStatus.OK);
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/bookings/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public void getUserBookingById(@PathVariable Long bookingId) {
        bookingService.deleteUserBookingById(bookingId);
    }

}
