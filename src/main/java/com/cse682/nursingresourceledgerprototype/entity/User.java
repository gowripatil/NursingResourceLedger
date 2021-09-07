package com.cse682.nursingresourceledgerprototype.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User entity object that is stored in User table.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
