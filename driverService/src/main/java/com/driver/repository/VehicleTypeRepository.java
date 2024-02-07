package com.driver.repository;

import com.driver.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

//    List<VehicleType> get

}
