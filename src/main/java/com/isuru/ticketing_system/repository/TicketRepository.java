package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
