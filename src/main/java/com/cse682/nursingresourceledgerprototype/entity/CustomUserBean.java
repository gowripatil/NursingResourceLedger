package com.cse682.nursingresourceledgerprototype.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserBean implements UserDetails {
    private static final long serialVersionUID = -4709084843450077569L;
    private Integer id;
    private String userName;
    private String email;
    @JsonIgnore private String password;
    private String firstName;
    private String lastName;

    private Collection<? extends GrantedAuthority> authorities;

    CustomUserBean(Integer id, String userName, String email,
                   String password, String firstName, String lastName,
                   Collection<? extends GrantedAuthority> authorities){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }

    public static CustomUserBean createInstance(User user) {
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        return new CustomUserBean(user.getId(), user.getUserName(),
                user.getEmail(), user.getPassword(),
                user.getFirstName(), user.getLastName(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof CustomUserBean) {
            return userName.equals(((CustomUserBean) rhs).userName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}
