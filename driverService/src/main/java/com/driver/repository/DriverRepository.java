package com.driver.repository;

import com.driver.entity.Driver;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("ALL")
public interface DriverRepository extends JpaRepository<Driver, String> {

    Driver saveAndFlush(Driver driver);

//    @Query("SELECT d FROM Driver d WHERE d.status = true AND d.availableFrom LIKE CONCAT('%', :availableFrom, '%') AND d.vehicle_type = :type")
//    List<Driver> findByStatusAndAvailableFromContaining(@Param("availableFrom") String availableFrom, @Param("type")  String type);

    List<Driver> findByStatusAndAvailableFromContainingAndVehicleType(boolean status, String availableFrom, String vehicleType);

}
