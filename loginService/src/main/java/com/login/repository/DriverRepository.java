package com.login.repository;

import com.login.DTO.DriverDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverDTO, String> {
    DriverDTO findByEmail(String email);
}
