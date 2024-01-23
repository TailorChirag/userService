package com.scaler.userservice.Service;

import com.scaler.userservice.Models.User;

import java.util.List;

public interface UserService {

    User getAllUsers();

    List<User> getSingleUser(Long id);

    User addUser(User user);

    User updateUser(User id,User user);

    void deleteUser(Long id);

}
