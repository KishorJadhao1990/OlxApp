package com.zensar.configuration;

import com.zensar.exception.BadRequestException;
import com.zensar.model.User;
import com.zensar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Optional<User> userOpt = userService.fetchUserByUsername(username);
        User user = userOpt.orElseThrow(() -> new BadRequestException("error.invalidCredentials"));
        if (user.getRoles().isEmpty()) {
            user.getRoles().stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleCode())));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}
