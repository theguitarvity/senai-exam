package com.mrlopito.senai.exam.crud.domain.response;

import com.mrlopito.senai.exam.crud.domain.entities.SystemUser;

public class AuthUserResponse {

    private String authToken;
    private SystemUser user;

    public AuthUserResponse(String authToken, SystemUser user) {
        this.authToken = authToken;
        this.user = user;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }
}
