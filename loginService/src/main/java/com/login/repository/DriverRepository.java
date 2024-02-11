package com.login.repository;

import com.login.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {
    Driver findByEmail(String email);
}
