package com.billing.service.impl;

import com.billing.DTO.BillingDTO;
import com.billing.constants.BillingConstants;
import com.billing.entity.Billing;
import com.billing.repository.BillingRepository;
import com.billing.service.BillingService;
import com.billing.utils.BillingUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<String> billPay(BillingDTO billingDTO) {
        try {
            Billing billing = dtoToBilling(billingDTO);

            String billingId = UUID.randomUUID().toString();
            billing.setBillingId(billingId);

            billingRepository.saveAndFlush(billing);
            log.info("Bill paid successfully");
            return BillingUtils.getResponseEntity("Bill paid successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while paying bill", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getBillDetailsById(String billingId) {
        try {
            log.info("Getting bill details by billing id");
            Optional<Billing> billing = billingRepository.findById(billingId);
            if(!billing.isPresent()) {
                return new ResponseEntity<>("Bill does not exist with this id", HttpStatus.NOT_FOUND);
            }
            BillingDTO billingDTO = billingToDto(billing.get());
            return new ResponseEntity<>(billingDTO, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting bill details by billing id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<?> getBillListByDriverId(String driverId) {
        try {
            log.info("Getting bill list by driver id");
            List<Billing> driverBillList = billingRepository.findByDriverId(driverId);

            if (driverBillList == null || driverBillList.isEmpty()) {
                return new ResponseEntity<>("No bill available right now", HttpStatus.NOT_FOUND);
            }

            List<BillingDTO> billList = driverBillList.stream()
                    .map(bill -> billingToDto(bill))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(billList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting bill list by driver id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<?> getBillListByPassengerId(String passengerId) {
        try {
            log.info("Getting bill list by driver id");
            List<Billing> passengerBillList = billingRepository.findByPassengerId(passengerId);

            if (passengerBillList == null || passengerBillList.isEmpty()) {
                return new ResponseEntity<>("No bill available right now", HttpStatus.NOT_FOUND);
            }

            List<BillingDTO> billList = passengerBillList.stream()
                    .map(bill -> billingToDto(bill))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(billList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while getting bill list by passenger id", e);
        }
        return BillingUtils.getResponseEntity(BillingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public Billing dtoToBilling(BillingDTO billingDTO) {
        return this.modelMapper.map(billingDTO, Billing.class);
    }

    public BillingDTO billingToDto(Billing billing) {
        return this.modelMapper.map(billing, BillingDTO.class);
    }


}
