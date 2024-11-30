package com.example.latriumback.service;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.User;
import com.example.latriumback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        if (user == null) return null;
        return new UserDTO(user.getUsername(), user.getRole());
    }
}
