package com.billing.service;

import com.billing.DTO.BillingDTO;
import org.springframework.http.ResponseEntity;

public interface BillingService {
    public ResponseEntity<?> getBillListByDriverId(String driverId);

    public ResponseEntity<String> billPay(BillingDTO billingDTO);
    public ResponseEntity<?> getBillDetailsById(String billingId);

    public ResponseEntity<?> getBillListByPassengerId(String passengerId);
}
