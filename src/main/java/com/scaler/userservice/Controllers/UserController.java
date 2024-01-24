package com.scaler.userservice.Controllers;

import com.scaler.userservice.Models.User;
import com.scaler.userservice.Service.ServiceInterface;
import com.scaler.userservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   private ServiceInterface userService;

   @Autowired
    public UserController(@Qualifier("userService") ServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws ProductNotFoundException {
       if(userService.getAllUsers().isEmpty()){
           throw new ProductNotFoundException("No users found");
       }
       return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id") Long id) throws ProductNotFoundException {
       return new ResponseEntity<>(
               userService.getSingleUser(id),
               HttpStatus.OK
       );
    }

    @PostMapping
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user) throws ProductNotFoundException {
       return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.resolve(200));
    }


}
