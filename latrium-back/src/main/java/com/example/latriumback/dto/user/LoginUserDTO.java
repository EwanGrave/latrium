package com.example.latriumback.dto.user;

public class LoginUserDTO {
    private boolean success;
    private UserDTO user;

    public LoginUserDTO(boolean success, UserDTO user) {
        this.success = success;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public UserDTO getUser() {
        return user;
    }
}
