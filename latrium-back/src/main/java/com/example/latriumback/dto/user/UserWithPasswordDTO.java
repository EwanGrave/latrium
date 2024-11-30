package com.example.latriumback.dto.user;

import com.example.latriumback.entity.User;
import com.example.latriumback.utils.UserRole;

public class UserWithPasswordDTO extends UserDTO {
    private String password;

    public UserWithPasswordDTO(String username, UserRole role, String password) {
        super(username, role);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static UserWithPasswordDTO convertToDTO(User user) {
        return new UserWithPasswordDTO(user.getUsername(), user.getRole(), user.getPassword());
    }
}
