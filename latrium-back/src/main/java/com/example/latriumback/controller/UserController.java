package com.example.latriumback.controller;

import com.example.latriumback.dto.user.CredentialsDTO;
import com.example.latriumback.dto.user.LoginUserDTO;
import com.example.latriumback.dto.user.UserWithPasswordDTO;
import com.example.latriumback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginUserDTO getUserFromCredentials(@RequestBody CredentialsDTO credentials)  {
        return userService.getUserFromCredentials(credentials);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserWithPasswordDTO user) {
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
