package com.login.repository;

import com.login.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {

    Passenger findByEmail(String email);

}
