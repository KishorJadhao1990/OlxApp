package com.zensar.controller;

import com.zensar.dto.LoginDto;
import com.zensar.exception.BadRequestException;
import com.zensar.model.User;
import com.zensar.dto.UserDto;
import com.zensar.service.UserService;
import com.zensar.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/sign-up", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> signUp(@Valid @RequestBody UserDto userDto) {
        User user = userDto.buildUserModel();
        Optional<User> userOptional = userService.registerUser(user);
        if (!userOptional.isPresent()) {
            throw new BadRequestException("error.failedToRegistered");
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/sign-in", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> signIn(@Valid @RequestBody LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new BadCredentialsException("error.invalidCredentials");
        }
        Optional<User> userOpt = userService.fetchUserByUsername(username);
        User user = userOpt.orElseThrow(() -> new BadCredentialsException("error.invalidCredentials"));
        Map<String, Object> resultMap = new LinkedHashMap<>();
        String jwtToken = jwtUtil.generateToken(username);
        resultMap.put("token", jwtToken);
        resultMap.put("User", user);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @GetMapping(value = "/validate-token", produces = "application/json")
    public ResponseEntity<User> validateLoginToken(@RequestHeader("Authorization") @NotEmpty String token) {
        token = token.substring(7);
        String username = jwtUtil.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        boolean isValidToken = jwtUtil.validateToken(token, userDetails);
        Optional<User> userOpt = userService.fetchUserByUsername(username);
        if (!isValidToken || !userOpt.isPresent()) {
            throw new BadRequestException("invalid.authenticationToken");
        }
        return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<User> fetchUser(@PathVariable("userId") Long userId) {
        Optional<User> userOptional = userService.fetchUser(userId);
        if (!userOptional.isPresent()) {
            throw new BadRequestException("error.userNotFound");
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

}
