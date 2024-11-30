package com.example.latriumback.controller;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/{name}")
    public UserDTO getUserByUsername(@PathVariable String name)  {
        return userService.findByUsername(name);
    }
}
