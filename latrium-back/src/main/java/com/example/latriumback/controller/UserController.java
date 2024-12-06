package com.example.latriumback.controller;

import com.example.latriumback.dto.user.UserDTO;
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

    @GetMapping("/{name}")
    public UserDTO getUserByUsername(@PathVariable String name)  {
        return userService.findByUsername(name);
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(@RequestBody UserWithPasswordDTO user) {
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
