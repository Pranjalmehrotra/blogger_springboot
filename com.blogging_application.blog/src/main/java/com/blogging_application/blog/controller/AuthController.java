package com.blogging_application.blog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogging_application.blog.model.AuthModelRequest;
import com.blogging_application.blog.model.JwtAuthResponse;
import com.blogging_application.blog.model.UserModel;
import com.blogging_application.blog.service.UserDetailsServiceImpl;
import com.blogging_application.blog.service.UserService;
import com.blogging_application.blog.utils.JwtTokenHelper;

import jakarta.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtAuthResponse> login(@RequestBody AuthModelRequest authModelRequest) throws Exception {
        System.out.println("Executing login method");
        authenticate(authModelRequest.getEmail(), authModelRequest.getPassword());

        // we need to generate the jwt token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authModelRequest.getEmail());

        final String token = jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);

    }

    private void authenticate(String email, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("User disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials");
        }

    }

    @PostMapping("/register-new-user")
    public ResponseEntity<UserModel> registerNewUser(@Valid @RequestBody UserModel userModel) {
    	System.out.println("AuthController.registerNewUser()");
        UserModel newUserModel = this.userService.registerNewUser(userModel);

        return new ResponseEntity<UserModel>(newUserModel, HttpStatus.CREATED);
    }

}
