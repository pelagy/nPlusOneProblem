package com.example.nplusone.service;

import com.example.nplusone.entity.User;
import com.example.nplusone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser (User user) {
        Optional.ofNullable(user)
                .map(userRepository::save)
                .map(User::getId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
