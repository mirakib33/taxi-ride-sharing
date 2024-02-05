package com.driver.DTO;

import com.driver.entity.Driver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDriverDTO {

    private Long id;
    private String place;
    private boolean activeStatus;

}
