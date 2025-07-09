package com.cognizant.spring_learn.controller;

import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.security.JwtUtility;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> generateJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String[] creds = decodeBasicAuth(authHeader);

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(creds[0], creds[1])
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(creds[0]);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    private String[] decodeBasicAuth(String authHeader) {
        String base64Creds = authHeader.substring("Basic ".length());
        String decoded = new String(Base64.getDecoder().decode(base64Creds));
        return decoded.split(":", 2);
    }
}