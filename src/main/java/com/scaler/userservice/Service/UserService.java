package com.scaler.userservice.Service;

import com.scaler.userservice.Models.User;
import com.scaler.userservice.exceptions.ProductNotFoundException;
import com.scaler.userservice.exceptions.UsernameNotFoundException;
import com.scaler.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("userService")
public class UserService implements ServiceInterface{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(Long id) throws ProductNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new ProductNotFoundException("User with id " + id + " not found");
        }
        return userOptional.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) throws ProductNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new ProductNotFoundException("User with id " + id + " not found");
        }

        User updatedUser = userOptional.get();

        if(user.getEmail() != null){
        updatedUser.setEmail(user.getEmail());
        }
        if(user.getUsername() != null){
            updatedUser.setUsername(user.getUsername());
        }
        if(user.getPassword() != null){
            updatedUser.setPassword(user.getPassword());
        }
        if(user.getName().getFirstName() != null){
            updatedUser.getName().setFirstName(user.getName().getFirstName());
        }
        if(user.getName().getLastName() != null){
            updatedUser.getName().setLastName(user.getName().getLastName());
        }
        if (user.getAddress().getCity() != null){
            updatedUser.getAddress().setCity(user.getAddress().getCity());
        }
        if(user.getAddress().getStreet() != null){
            updatedUser.getAddress().setStreet(user.getAddress().getStreet());
        }
        if(user.getAddress().getNumber() != null){
            updatedUser.getAddress().setNumber(user.getAddress().getNumber());
        }
        if(user.getAddress().getZipcode() != null){
            updatedUser.getAddress().setZipcode(user.getAddress().getZipcode());
        }
        if(user.getAddress().getGeo().getLatitude() != null){
            updatedUser.getAddress().getGeo().setLatitude(user.getAddress().getGeo().getLatitude());
        }
        if(user.getAddress().getGeo().getLongitude() != null){
            updatedUser.getAddress().getGeo().setLongitude(user.getAddress().getGeo().getLongitude());
        }
        if(user.getPhone() != null){
            updatedUser.setPhone(user.getPhone());
        }

        return userRepository.save(updatedUser);
    }

    @Override
    public boolean deleteUser(Long id) throws ProductNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new ProductNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User userLogin(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }

        return userRepository.findByUsernameAndPassword(username, password);
    }


}
