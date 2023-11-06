package com.mrlopito.senai.exam.crud.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public class AuthenticateUserDTO {

    @NotBlank(message = "Username must be provided")
    private String username;
    @NotBlank(message = "Password must be provided")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
