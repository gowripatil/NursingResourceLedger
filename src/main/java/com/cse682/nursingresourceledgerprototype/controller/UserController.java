package com.cse682.nursingresourceledgerprototype.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class UserController {
    @GetMapping("/allusers")
    public String displayUsers() {
        return "Display All Users";
    }

    @GetMapping("/displayuser")
    @PreAuthorize("hasRole('ROLE_NURSE')")
    public String displayToUser() {
        return "Display only to nurse";
    }

    @GetMapping("/displayadmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String displayToAdmin() {
        return "Display only to admin";
    }
}
