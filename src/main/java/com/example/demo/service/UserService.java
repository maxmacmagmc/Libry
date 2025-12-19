package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUsername());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser.getId(), savedUser.getUserName());

    }
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getUserName()))
                .collect(Collectors.toList());
    }
}