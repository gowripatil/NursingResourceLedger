package com.cse682.nursingresourceledgerprototype.entity;

import java.util.List;

/**
 * This class represents the response you get back when logging in.
 * It includes the authentication token and the roles user is authorized for.
 */
public class AuthResponse {
    private String token;
    private List<String> roles;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
