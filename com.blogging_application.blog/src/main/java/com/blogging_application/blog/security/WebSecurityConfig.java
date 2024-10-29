package com.blogging_application.blog.security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blogging_application.blog.service.UserDetailsServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@ComponentScan("com.blogging_application.blog")
public class WebSecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("executing filterChain");
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request -> request.requestMatchers("/login", "/register").permitAll().anyRequest()
                        .authenticated())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.httpBasic(withDefaults()).authenticationProvider(authenticationProvider());
        return http.build();

    }

	/*
	 * @Bean ModelMapper modelMapper() { return new ModelMapper(); }
	 * 
	 * @Bean public static PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("Executing authenticationProvider");
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new BlogAuthenticationManager(passwordEncoder, userDetailsService);
    }


}

