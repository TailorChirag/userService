package com.scaler.userservice.Service;

import com.scaler.userservice.Models.User;

public interface ServiceInterface {

    User getAllUsers();

    User getSingleUser(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    User deleteUser(Long id);

}
