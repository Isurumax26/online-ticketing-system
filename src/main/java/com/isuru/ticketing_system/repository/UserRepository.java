package com.isuru.ticketing_system.repository;

import com.isuru.ticketing_system.repository.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
