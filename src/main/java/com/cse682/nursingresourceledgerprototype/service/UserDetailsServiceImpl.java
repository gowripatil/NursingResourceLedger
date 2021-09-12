package com.cse682.nursingresourceledgerprototype.service;

import com.cse682.nursingresourceledgerprototype.entity.CustomUserBean;
import com.cse682.nursingresourceledgerprototype.entity.User;
import com.cse682.nursingresourceledgerprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with "
                        + "user name "+ username + " not found"));
        return CustomUserBean.createInstance(user);
    }
}
