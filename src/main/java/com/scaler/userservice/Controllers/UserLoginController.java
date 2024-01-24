package com.scaler.userservice.Controllers;

import com.scaler.userservice.Models.User;
import com.scaler.userservice.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserLoginController {

    private ServiceInterface userService;

    @Autowired
    public UserLoginController(@Qualifier("userService") ServiceInterface userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User userLogin){
        userService.userLogin(userLogin.getUsername(),userLogin.getPassword());
        return " Ye User Logged in hai  " ;
    }
}
