package com.ride.repository;

import com.ride.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface RideRepository extends JpaRepository<Ride, String> {

    Ride saveAndFlush(Ride ride);

    @Query("SELECT r FROM Ride r WHERE r.passengerId = :passengerId AND (r.status = :status1 OR r.status = :status2 OR r.status = :status3)")
    Optional<Ride> findByPassengerIdAndStatus(@Param("passengerId") String passengerId, @Param("status1") String status1, @Param("status2") String status2, @Param("status3") String status3);

    @Query("SELECT r FROM Ride r WHERE r.driverId = :driverId AND r.status NOT IN (:status1, :status2, :status3)")
    List<Ride> findByDriverId(@Param("driverId") String driverId, @Param("status1") String status1, @Param("status2") String status2, @Param("status3") String status3);

    @Query("SELECT r FROM Ride r WHERE r.driverId = :driverId AND (r.status = :status1 OR r.status = :status2)")
    List<Ride> findByDriverIdAndStatus(@Param("driverId") String driverId, @Param("status1") String status1, @Param("status2") String status2);


}
