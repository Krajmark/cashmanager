package com.krajmark.cashmanager.service.impl;

import com.krajmark.cashmanager.mappers.SignupMapper;
import com.krajmark.cashmanager.repository.UserRepository;
import com.krajmark.cashmanager.requests.SignupRequest;
import com.krajmark.cashmanager.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final SignupMapper signupMapper;

    public UserServiceImpl(UserRepository userRepository, SignupMapper signupMapper) {
        this.userRepository = userRepository;
        this.signupMapper = signupMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
    }

    @Override
    public String register(SignupRequest signupRequest) {
        if(Objects.equals(signupRequest.getPassword(), signupRequest.getPasswordConfirm())) {
            if(userRepository.findByUsername(signupRequest.getUsername()).isEmpty()) {
                userRepository.save(signupMapper.apply(signupRequest));

                return "User registered";
            }

            return "Username already taken";
        }
        return "Passwords don't match";
    }
}
