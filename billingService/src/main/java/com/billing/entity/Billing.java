package com.billing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "billing")
public class Billing {

    @Id
    @Column(name = "billing_id")
    private String billingId;

    @Column(name = "ride_id")
    private String rideId;

    @Column(name = "passenger_id")
    private String passengerId;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "payment_date")
    private Date payment_date;

    @Column(name = "amount", nullable = false)
    private Double amount;


}
