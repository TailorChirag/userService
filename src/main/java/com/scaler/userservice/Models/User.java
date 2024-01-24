package com.scaler.userservice.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String email;
    private String username;
    private String password;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private UserName name;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private UserAddress address;
    private String phone;


}
