package com.blogging_apllication.blog.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogging_application.blog.entity.UserEntity;
import com.blogging_application.blog.repository.UserRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity existingUser = userRepository
				.findByUserEmail("%"+email + "%").orElseThrow(() -> new UsernameNotFoundException("User not found for the email:"+email));
		
		return new User(existingUser.getEmailAddress(), existingUser.getPassword(), new ArrayList<>());
	}

}