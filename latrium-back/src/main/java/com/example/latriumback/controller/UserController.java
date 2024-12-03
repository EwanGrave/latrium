package com.example.latriumback.controller;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.dto.user.UserWithPasswordDTO;
import com.example.latriumback.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/{name}")
    public UserDTO getUserByUsername(@PathVariable String name)  {
        return userService.findByUsername(name);
    }

    @PostMapping("/api/register")
    public void registerUser(@RequestBody UserWithPasswordDTO user) {
        userService.saveUser(user);
    }
}
