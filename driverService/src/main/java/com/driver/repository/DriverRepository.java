package com.driver.repository;

import com.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("ALL")
public interface DriverRepository extends JpaRepository<Driver, String> {

    Driver saveAndFlush(Driver driver);

    @Query("SELECT d FROM Driver d WHERE d.status = true AND d.available_from LIKE %:place%")
    List<Driver> findByStatusAndAvailableFromContaining(@Param("place") String availableFrom);
}
