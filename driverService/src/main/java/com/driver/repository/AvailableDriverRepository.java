package com.driver.repository;

import com.driver.entity.AvailableDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDriverRepository extends JpaRepository<AvailableDriver, Long> {

//    AvailableDriver updateAvailableDriverById(Long id, AvailableDriver availableDriver);

}
