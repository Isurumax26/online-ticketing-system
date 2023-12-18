package com.isuru.ticketing_system.services;

import com.isuru.ticketing_system.model.BookingOrder;

import com.isuru.ticketing_system.model.UserBooking;
import com.isuru.ticketing_system.repository.BookingRepository;
import com.isuru.ticketing_system.repository.BookingTicketRepository;
import com.isuru.ticketing_system.repository.UserRepository;
import com.isuru.ticketing_system.repository.dao.*;
import com.isuru.ticketing_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingTicketRepository bookingTicketRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets =  ticketRepository.findAll();
        return  tickets;
    }

    public boolean createBooking(long userId, List<BookingOrder> bookingOrders) {
        LocalDate bookingDate = LocalDate.now();
        User bookedUser = userRepository.findById(userId).get();

        Booking newBooking = new Booking();
        newBooking.setUser(bookedUser);
        newBooking.setBookingDate(bookingDate);
        newBooking.setBookingStatus(BookingStatus.ACTIVE);

        bookingRepository.save(newBooking);

        for (BookingOrder order : bookingOrders) {
            long ticketId = order.getTicketId();
            int numOfTickets = order.getNumOfTickets();

            Ticket ticket = ticketRepository.findById(ticketId).get();

            // handle the error if remaining tickets are lesser than the ordered tickets

            BookingTicket bookingTicket = new BookingTicket();
            bookingTicket.setTicket(ticket);
            bookingTicket.setNumOfTickets(numOfTickets);
            bookingTicket.setBooking(newBooking);
            bookingTicketRepository.save(bookingTicket);
        }

        return true;
    }

    public UserBooking getAllUserBookings(long userId) {
        UserBooking userBooking = new UserBooking();
        List<BookingTicket> bookingTickets = bookingTicketRepository.findByUser(userId);

        userBooking.setUserBookings(bookingTickets);
        return userBooking;

    }

    public UserBooking getUserBookingById(long userId, long bookingId) {
        UserBooking userBooking = new UserBooking();
        List<BookingTicket> bookingTickets = bookingTicketRepository.findByUserAndBookingId(userId, bookingId);

        userBooking.setUserBookings(bookingTickets);
        return userBooking;
    }

}
