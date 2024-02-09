package com.billing.DTO;

import jakarta.persistence.Column;
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

    @Column(name = "ride_id", nullable = false)
    private String rideId;

    @Column(name = "passenger_id", nullable = false)
    private String passengerId;

    @Column(name = "driver_id", nullable = false)
    private String driverId;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "payment_date", nullable = false)
    private Date payment_date;

}
