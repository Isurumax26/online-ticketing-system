package com.isuru.ticketing_system.controller;

import com.isuru.ticketing_system.model.BookingOrder;
import com.isuru.ticketing_system.repository.dao.Ticket;
import com.isuru.ticketing_system.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{userID}/bookings")
    public ResponseEntity<HttpStatus> createNewBooking(List<BookingOrder> bookingOrders, @PathVariable Long userId) {
        boolean status = bookingService.createBooking(userId, bookingOrders);
        return status ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
