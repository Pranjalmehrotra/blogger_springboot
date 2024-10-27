package com.blogging_application.blog.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.blogging_application.blog.entity.UserEntity;
import com.blogging_application.blog.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        UserEntity existingUser = userRepository
                .findByUserEmail("%" + email + "%").orElseThrow(() -> new UsernameNotFoundException("User not found for the email:" + email));
        System.out.println("Email : " + email);
        System.out.println("Password : " + existingUser.getPassword());
        return new User(existingUser.getEmailAddress(), passwordEncoder.encode(existingUser.getPassword()), new ArrayList<>());
    }

}