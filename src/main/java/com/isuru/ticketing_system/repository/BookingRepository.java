package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
