package com.krajmark.cashmanager.mappers;

import com.krajmark.cashmanager.app_enum.Role;
import com.krajmark.cashmanager.entity.User;
import com.krajmark.cashmanager.requests.SignupRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

 @Component
public class SignupMapper implements Function<SignupRequest, User> {

    private final BCryptPasswordEncoder passwordEncoder;

    public SignupMapper(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User apply(SignupRequest signupRequest) {
        return new User(
                signupRequest.getUsername(),
                passwordEncoder.encode(signupRequest.getPassword()),
                Role.USER
        );
    }
}
