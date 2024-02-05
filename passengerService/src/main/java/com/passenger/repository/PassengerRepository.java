package com.passenger.repository;

import com.passenger.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Passenger saveAndFlush(Passenger passenger);

}
