package com.example.latriumback.dto.user;

import com.example.latriumback.entity.User;
import com.example.latriumback.utils.UserRole;

public class UserDTO {
    private Long idUser;
    private String username;
    private UserRole role;

    public UserDTO(Long idUser, String username, UserRole role) {
        this.username = username;
        this.role = role;
        this.idUser = idUser;
    }

    public UserDTO() {}

    public static UserDTO convertToDTO(User user) {
        return new UserDTO(user.getIdUser(), user.getUsername(), user.getRole());
    }

    public static User convertToEntity(UserDTO user) {
        return new User(user.getIdUser(), user.getUsername(), user.getRole());
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }

    public Long getIdUser() {
        return idUser;
    }
}
