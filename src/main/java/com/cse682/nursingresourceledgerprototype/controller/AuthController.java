package com.cse682.nursingresourceledgerprototype.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cse682.nursingresourceledgerprototype.entity.*;
import com.cse682.nursingresourceledgerprototype.repository.RoleRepository;
import com.cse682.nursingresourceledgerprototype.repository.UserRepository;
import com.cse682.nursingresourceledgerprototype.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * AuthController class handles user login and registration.
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/auth")
public class AuthController {
    @Autowired UserRepository userRepository;
    @Autowired RoleRepository roleRepository;
    @Autowired PasswordEncoder encoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired JwtTokenUtil jwtTokenUtil;

    /**
     * POST method to handle user login.
     * User calls POST http://localhost:8080/auth/login REST API. UserName and
     * Password in the request body and the response is
     * 200 - If credentials are valid
     * 400 - If credentials are invalid
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody User user) {
        //System.out.println("AuthController -- userLogin");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateJwtToken(authentication);
        CustomUserBean userBean = (CustomUserBean) authentication.getPrincipal();
        List<String> roles = userBean.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .collect(Collectors.toList());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setRoles(roles);
        return ResponseEntity.ok(authResponse);
    }

    /**
     * POST method to handle user signup .
     * User calls POST http://localhost:8080/auth/signup REST API. User Details
     * are passed in the request body and the response is
     * 200 - If the registration is successful
     * 400 - If the UserName or Email is already taken.
     * @param signupRequest
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<?> userSignup(@RequestBody SignupRequest signupRequest) {
        if(userRepository.existsByUserName(signupRequest.getUserName())){
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body("Email is already taken");
        }
        User user = new User();
        Set<Role> roles = new HashSet<>();
        user.setUserName(signupRequest.getUserName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        //System.out.println("Encoded password--- " + user.getPassword());
        String[] roleArr = signupRequest.getRoles();

        for(String role: roleArr) {
            switch(role.toLowerCase()) {
                case "admin":
                    roles.add(roleRepository.findByRoleName(Roles.ROLE_ADMIN).get());
                    break;
                case "nurse":
                    roles.add(roleRepository.findByRoleName(Roles.ROLE_NURSE).get());
                    break;
                default:
                    return ResponseEntity.badRequest().body("Specified role not found");
            }
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok("User signed up successfully");
    }
}
