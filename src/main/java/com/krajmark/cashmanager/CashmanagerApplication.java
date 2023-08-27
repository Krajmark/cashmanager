package com.krajmark.cashmanager;

import com.krajmark.cashmanager.model.BaseUser;
import com.krajmark.cashmanager.repository.BaseUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CashmanagerApplication implements CommandLineRunner {

    private final BaseUserRepo baseUserRepo;
    private final PasswordEncoder passwordEncoder;

    public CashmanagerApplication(BaseUserRepo baseUserRepo, PasswordEncoder passwordEncoder) {
        this.baseUserRepo = baseUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(CashmanagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BaseUser testUser = new BaseUser();
        testUser.setBalance(10000);
        testUser.setUsername("krajmark");
        testUser.setPassword(this.passwordEncoder.encode("asdasd"));
        this.baseUserRepo.save(testUser);
    }
}
