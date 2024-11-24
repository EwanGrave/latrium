package com.example.latriumback.dto;

import com.example.latriumback.utils.UserRole;

public class UserDTO {
    private String username;
    private UserRole role;

    public UserDTO(String username, UserRole role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }
}
