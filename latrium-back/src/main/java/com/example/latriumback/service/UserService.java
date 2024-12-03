package com.example.latriumback.service;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.dto.user.UserWithPasswordDTO;
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
        return UserDTO.convertToDTO(user);
    }

    public void saveUser(UserWithPasswordDTO user) {
        userRepository.save(UserWithPasswordDTO.convertToEntity(user));
    }
}
