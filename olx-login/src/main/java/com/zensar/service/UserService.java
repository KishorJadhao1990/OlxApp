package com.zensar.service;

import com.zensar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> registerUser(User user);
    Optional<User> fetchUser(Long id);
    List<User> fetchAllUsers();
    Optional<User> fetchUserByEmail(String email);
    Optional<User> fetchUserByUsername(String email);
    Optional<User> fetchUserByMobileNo(String email);

}
