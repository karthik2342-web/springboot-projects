package com.ust.securityh2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.ust.securityh2.entity.UserTO;
import com.ust.securityh2.util.MyJwtUtil;

@RestController
@RequestMapping("/api") // Define a specific base path for the API
public class MyController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MyJwtUtil myJwtUtil;

    @GetMapping("/")
    public String welcome() {
        return "Home page";
    }

    @GetMapping("/api1")
    public String api1() {
        return "api1 !!";
    }

    @GetMapping("/api2")
    public String api2() {
        return "api2 !!";
    }

    @PostMapping("/api3")
    public ResponseEntity<String> api3(@RequestBody UserTO userTO) {
        return ResponseEntity.ok("api3 !!");
    }

    @PostMapping("/api4")
    public ResponseEntity<String> api4(@RequestBody UserTO userTO) {
        return ResponseEntity.ok("api4 !!");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> generateToken(@RequestBody UserTO userTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userTO.getUserName(), userTO.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username/password");
        }
        
        String token = myJwtUtil.generateToken(userTO.getUserName());
        return ResponseEntity.ok().body(new TokenResponse(token)); // Return structured response
    }

    // Inner class to represent the token response
    static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
