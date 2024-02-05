package com.driver.repository;

import com.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface DriverRepository extends JpaRepository<Driver, String> {

    Driver saveAndFlush(Driver driver);


}
