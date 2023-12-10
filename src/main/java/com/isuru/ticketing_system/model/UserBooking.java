package com.isuru.ticketing_system.model;

import com.isuru.ticketing_system.repository.dao.BookingTicket;

import java.util.List;

public class UserBooking {

    List<BookingTicket> userBookings;

    public List<BookingTicket> getUserBookings() {
        return userBookings;
    }

    public void setUserBookings(List<BookingTicket> userBookings) {
        this.userBookings = userBookings;
    }
}
