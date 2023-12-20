package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.Booking;
import com.isuru.ticketing_system.repository.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring data JPA Methods work with the properties in the domain class
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //long deleteByIdAndUser(long id, User user);


}
