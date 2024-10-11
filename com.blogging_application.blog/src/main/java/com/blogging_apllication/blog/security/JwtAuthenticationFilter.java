package com.blogging_apllication.blog.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blogging_application.blog.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	/*
	 * @Override protected boolean shouldNotFilter(HttpServletRequest request)
	 * throws ServletException { // TODO Auto-generated // method stub String path =
	 * String path = request.getRequestURI();
	 * 
	 * System.out.println("should Not Filter Called with value: " + path + " : " +
	 * "/t-bank/login".equals(path)); return
	 * "/flutter_backend_project/login".equals(path);
	 * 
	 * }
	 */

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String requestTokenHeader = request.getHeader("Authorization");

		System.out.println("The request token is ::" + requestTokenHeader);

		String jwtToken = null;
		String username = null;

		// Sample Request token::
		// Bearer 234567890000005678ujiop

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			jwtToken = requestTokenHeader.substring(7);

			try {
				username = jwtTokenHelper.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException("Unable to get JWT token");
			} catch (ExpiredJwtException e) {
				throw new RuntimeException("Jwt token has expired");
			} catch (MalformedJwtException e) {
				throw new RuntimeException("Invalid Jwt exception");

			}

		}

		// Once we get the token, validate the token
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtTokenHelper.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());

				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authToken);

			}

		}

		filterChain.doFilter(request, response);

	}

}
