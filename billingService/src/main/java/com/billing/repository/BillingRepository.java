package com.billing.repository;

import com.billing.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, String> {
    List<Billing> findByDriverId(String driverId);

    List<Billing> findByPassengerId(String passengerId);
}
