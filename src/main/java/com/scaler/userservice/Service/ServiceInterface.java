package com.scaler.userservice.Service;

import com.scaler.userservice.Models.User;
import com.scaler.userservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ServiceInterface {

    List<User> getAllUsers();

    User getSingleUser(Long id) throws ProductNotFoundException;

    User createUser(User user);

    User updateUser(Long id, User user) throws ProductNotFoundException;

    boolean deleteUser(Long id) throws ProductNotFoundException;

    User userLogin(String username, String password);

}
