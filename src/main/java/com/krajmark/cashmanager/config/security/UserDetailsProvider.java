package com.krajmark.cashmanager.config.security;

import com.krajmark.cashmanager.model.BaseUser;
import com.krajmark.cashmanager.repository.BaseUserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsProvider implements UserDetailsService {
    private final BaseUserRepo baseUserRepo;

    public UserDetailsProvider(BaseUserRepo baseUserRepo) {
        this.baseUserRepo = baseUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BaseUser> user = this.baseUserRepo.findBaseUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user with such username found!");
        }
        return new User(
                user.get().getUsername(),
                user.get().getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_".concat("TEST")))
                );
    }
}
