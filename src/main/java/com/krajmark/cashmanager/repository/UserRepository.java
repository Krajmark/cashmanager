package com.krajmark.cashmanager.repository;

import com.krajmark.cashmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@ResponseBody
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
