package com.krajmark.cashmanager.config.init;

import com.krajmark.cashmanager.model.BaseUser;
import com.krajmark.cashmanager.repository.BaseUserRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitHandler implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
    private final BaseUserRepo baseUserRepo;

    public InitHandler(PasswordEncoder passwordEncoder, BaseUserRepo baseUserRepo) {
        this.passwordEncoder = passwordEncoder;
        this.baseUserRepo = baseUserRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BaseUser testUser = new BaseUser();
        testUser.setBalance(10000);
        testUser.setUsername("krajmark");
        testUser.setPassword(this.passwordEncoder.encode("asdasd"));
        this.baseUserRepo.save(testUser);
    }
}
