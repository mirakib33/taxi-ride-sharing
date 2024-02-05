package com.driver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "available_driver")
public class AvailableDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_id", nullable = false)
    private Long id;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "active_status")
    private boolean activeStatus;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "driver_id")
//    private Driver driver;

}
