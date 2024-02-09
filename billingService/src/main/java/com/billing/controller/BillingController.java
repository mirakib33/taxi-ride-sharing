package com.billing.controller;

import com.billing.DTO.BillingDTO;
import com.billing.constants.BillingConstants;
import com.billing.service.BillingService;
import com.billing.utils.BillingUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/pay")
    public ResponseEntity<String> billPay(@Valid @RequestBody BillingDTO billingDTO) {
        try {
            ResponseEntity<String> response = billingService.billPay(billingDTO);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while paying bill", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{billingId}")
    public ResponseEntity<?> getBillByBillingId(@PathVariable String billingId) {
        try {
            ResponseEntity<?> response = billingService.getBillDetailsById(billingId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting bill details by billing id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<?> getBillListByDriverId(@PathVariable String driverId) {
        try {
            ResponseEntity<?> response = billingService.getBillListByDriverId(driverId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting bill list by driver id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<?> getBillListByPassengerId(@PathVariable String passengerId) {
        try {
            ResponseEntity<?> response = billingService.getBillListByPassengerId(passengerId);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            log.error("Error occurred while getting bill list by passenger id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
