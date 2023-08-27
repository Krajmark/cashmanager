package com.krajmark.cashmanager.repository;

import com.krajmark.cashmanager.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseUserRepo extends JpaRepository<BaseUser, Integer> {
    Optional<BaseUser> findBaseUserByUsername(String username);
}
