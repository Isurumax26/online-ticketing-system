package com.isuru.ticketing_system.repository.dao;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numOfTickets;

    private int remainingTickets;

    private int price;

    @OneToMany(mappedBy = "ticket")
    private Set<BookingTicket> bookingTickets;

    public Set<BookingTicket> getBookingTickets() {
        return bookingTickets;
    }

    public void setBookingTickets(Set<BookingTicket> bookingTickets) {
        this.bookingTickets = bookingTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public int getRemainingTickets() {
        return remainingTickets;
    }

    public void setRemainingTickets(int remainingTickets) {
        this.remainingTickets = remainingTickets;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
