package com.cse682.nursingresourceledgerprototype.controller;

import com.cse682.nursingresourceledgerprototype.entity.User;
import com.cse682.nursingresourceledgerprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user, HttpServletRequest request, BindingResult bindingResult, Model model) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getFirstName());
        System.out.println(user.getFirstName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }
}
