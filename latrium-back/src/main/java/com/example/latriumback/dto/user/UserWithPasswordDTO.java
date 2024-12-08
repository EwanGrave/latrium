package com.example.latriumback.dto.user;

import com.example.latriumback.entity.User;
import com.example.latriumback.utils.UserRole;

public class UserWithPasswordDTO extends UserDTO {
    private String password;

    public UserWithPasswordDTO(Long idUser, String username, UserRole role, String password) {
        super(idUser, username, role);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static UserWithPasswordDTO convertToDTO(User user) {
        return new UserWithPasswordDTO(user.getIdUser(), user.getUsername(), user.getRole(), user.getPassword());
    }

    public static User convertToEntity(UserWithPasswordDTO user) {
        return new User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
