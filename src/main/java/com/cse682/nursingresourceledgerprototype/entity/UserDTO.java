package com.cse682.nursingresourceledgerprototype.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String userName;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
