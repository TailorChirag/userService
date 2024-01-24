package com.scaler.userservice.dtos;

import com.scaler.userservice.Models.UserAddress;
import com.scaler.userservice.Models.UserName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreUserDto {

    private Long id;
    private String email;
    private String username;
    private String password;
    private UserName name;
    private UserAddress address;
    private String phone;

}
