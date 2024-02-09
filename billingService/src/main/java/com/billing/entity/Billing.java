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


    private String billingId;

    @NotBlank(message = "Ride Id cannot be blank")
    private String rideId;

    @NotBlank(message = "Passenger Id cannot be blank")
    private String passengerId;

    @NotBlank(message = "Driver Id cannot be blank")
    private String driverId;

    @NotBlank(message = "Payment Method cannot be blank")
    private String paymentMethod;

    @NotBlank(message = "Transaction Id cannot be blank")
    private String transactionId;

    @NotBlank(message = "Payment Date annot be blank")
    private Date payment_date;

}
