package com.billing.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingDTO {

    private String billingId;

    private String rideId;

    private String passengerId;

    private String driverId;

    private String paymentMethod;

    private String transactionId;

    private Date payment_date;

    private Double amount;

}
