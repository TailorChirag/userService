package com.scaler.userservice.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserAddress extends BaseModel{

        private String city;
        private String street;
        private String number;
        private String zipcode;
        @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
        private UserAddressGeo geo;

}
