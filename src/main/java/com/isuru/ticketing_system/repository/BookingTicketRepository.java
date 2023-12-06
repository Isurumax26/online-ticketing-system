package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.BookingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingTicketRepository extends JpaRepository<BookingTicket, Long> {
}
