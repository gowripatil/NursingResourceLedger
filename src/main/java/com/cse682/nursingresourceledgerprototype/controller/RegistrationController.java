package com.cse682.nursingresourceledgerprototype.controller;

import com.cse682.nursingresourceledgerprototype.entity.User;
import com.cse682.nursingresourceledgerprototype.entity.UserDTO;
import com.cse682.nursingresourceledgerprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for http://localhost:8080/register.
 *
 * Get on a register page returns signup_form.html
 * Post on a register page returns register_success.html if registration is successful.
 *  Post API is called when user clicks save button on the register page.
 */
@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "signup_form";
    }

    @PostMapping(value = "/register")
    public String processRegister(UserDTO userDTO, Model model) {
        /*
        TODO: Spring boot security is not working. Will enable this code once that is fixed.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
         */

        model.addAttribute("userDTO", userDTO);
        System.out.println(userDTO);
        userRepository.save(new User());

        return "register_success";
    }
}
