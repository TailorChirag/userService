package com.scaler.userservice.repositories;

import com.scaler.userservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    User findByEmail(String email);

    void deleteById(Long id);

    Optional<User> findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);



}
