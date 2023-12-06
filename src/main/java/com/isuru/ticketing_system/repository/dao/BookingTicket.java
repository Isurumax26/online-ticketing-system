package com.isuru.ticketing_system.repository.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_tickets")
public class BookingTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingTicketId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private long numOfTickets;


    public long getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(long numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public long getBookingTicketId() {
        return bookingTicketId;
    }

    public void setBookingTicketId(long bookingTicketId) {
        this.bookingTicketId = bookingTicketId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


}
