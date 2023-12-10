package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.BookingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingTicketRepository extends JpaRepository<BookingTicket, Long> {

    @Query("SELECT a FROM BookingTicket a INNER JOIN a.booking b WHERE b.user.id = :userId")
    List<BookingTicket> findByUser(@Param("userId") Long userId);


}
