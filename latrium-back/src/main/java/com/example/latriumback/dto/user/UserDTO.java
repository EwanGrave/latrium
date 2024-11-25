package com.example.latriumback.dto.user;

import com.example.latriumback.entity.User;
import com.example.latriumback.utils.UserRole;

public class UserDTO {
    private String username;
    private UserRole role;

    public UserDTO(String username, UserRole role) {
        this.username = username;
        this.role = role;
    }

    public static UserDTO convertToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getRole());
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }
}
