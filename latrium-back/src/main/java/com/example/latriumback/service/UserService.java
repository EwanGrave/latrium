package com.example.latriumback.service;

import com.example.latriumback.dto.user.CredentialsDTO;
import com.example.latriumback.dto.user.LoginUserDTO;
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

    public LoginUserDTO getUserFromCredentials(CredentialsDTO credentials) {
        User user = userRepository.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        boolean success = user != null;
        return new LoginUserDTO(success, success ? UserDTO.convertToDTO(user) : new UserDTO());
    }

    public void createUser(UserWithPasswordDTO user) {
        userRepository.save(UserWithPasswordDTO.convertToEntity(user));
    }
}
