package com.scaler.userservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserName extends BaseModel{

    private String first;
    private String last;
}
