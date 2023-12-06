package com.isuru.ticketing_system.repository.dao;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;


    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDate bookingDate;

    @OneToMany(mappedBy = "booking")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
