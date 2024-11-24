package com.example.latriumback.service;

import com.example.latriumback.dto.UserDTO;
import com.example.latriumback.entity.User;
import com.example.latriumback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return convertToDTO(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        if (user == null) return null;
        return new UserDTO(user.getUsername(), user.getRole());
    }
}
