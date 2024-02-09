package com.ride.repository;

import com.ride.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;


public interface RideRepository extends JpaRepository<Ride, String> {

    Ride saveAndFlush(Ride ride);

    Optional<Ride> findByPassengerId(String passengerId);

    Optional<Ride> findByDriverId(String driverId);

//    @Modifying
//    @Query("UPDATE ride r SET r.status = :status WHERE r.ride_id = :rideId")
//    Optional<Ride> updateRideStatusByPassenger(String status, String rideId);

//    @Modifying
//    @Query("UPDATE ride r SET r.status = :status, r.accepted_on = :acceptedOn WHERE r.ride_id = :rideId")
//    void updateAcceptedStatusByDriver(String status, Date acceptedOn, String rideId);
//
//    @Modifying
//    @Query("UPDATE ride r SET r.status = :status, r.start_time = :endTime WHERE r.ride_id = :rideId")
//    void updateStartStatusByDriver(String status, Date startTime, String rideId);
//
//    @Modifying
//    @Query("UPDATE ride r SET r.status = :status, r.end_time = :endTime WHERE r.ride_id = :rideId")
//    void updateEndStatusByDriver(String status, Date endTime,String rideId);
//
//    @Modifying
//    @Query("UPDATE ride r SET r.status = :status WHERE r.ride_id = :rideId")
//    void updateCancelStatusByDriver(String status, String rideId);
}
