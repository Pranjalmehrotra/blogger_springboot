package com.blogging_application.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BlogAuthenticationManager implements AuthenticationManager {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public BlogAuthenticationManager(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final UserDetails userDetail = userDetailsService.loadUserByUsername(authentication.getName());
        if (!passwordEncoder.matches(authentication.getCredentials().toString(), userDetail.getPassword())) {
            throw new BadCredentialsException("Incorrect Credential");
        }
        return new UsernamePasswordAuthenticationToken(userDetail.getUsername(), userDetail.getPassword(), userDetail.getAuthorities());

    }
}
