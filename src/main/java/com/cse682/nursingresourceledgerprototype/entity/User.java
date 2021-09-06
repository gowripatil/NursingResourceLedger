package com.cse682.nursingresourceledgerprototype.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User entity object that is stored in User table.
 */
@Entity
public class User implements Serializable {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;

    @Column(nullable = false, unique = true, length = 32)
    private String userName;

    @Column(nullable = false, unique = true, length = 64)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last name", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false)
    private UserRoleType userRoleType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userName) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserRoleType getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(UserRoleType userRoleType) {
        this.userRoleType = userRoleType;
    }

    public User() {
    }

    public User(String userName,
                String email,
                String password,
                String firstName,
                String lastName,
                UserRoleType userRoleType) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRoleType = userRoleType;
    }
}
