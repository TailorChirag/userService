package com.scaler.userservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserAddressGeo extends BaseModel{

    private String latitude;
    private String longitude;
}
