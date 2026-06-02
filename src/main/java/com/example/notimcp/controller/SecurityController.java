package com.example.notimcp.controller;

import com.example.notimcp.security.ApiKeyValidator;
import com.example.notimcp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mcp")
public class SecurityController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private ApiKeyValidator apiKeyValidator;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestHeader("X-API-Key") String apiKey) {
        if (apiKeyValidator.isValidApiKey(apiKey)) {
            // In a real implementation, you would generate a JWT token
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(401).body("Invalid API key");
        }
    }

    @GetMapping("/auth/validate")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.ok("Token is valid");
            } else {
                return ResponseEntity.status(401).body("Invalid or expired token");
            }
        } else {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }
    }
}