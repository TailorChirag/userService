package com.scaler.userservice.Models;

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
    @OneToOne
    private UserName name;
    @OneToOne
    private UserAddress address;
    private String phone;


}
