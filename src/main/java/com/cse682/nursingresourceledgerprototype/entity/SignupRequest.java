package com.cse682.nursingresourceledgerprototype.entity;

/**
 * This class captures the data for the SignUp request which is sent when a new user registers.
 */
public class SignupRequest {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String[] roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
