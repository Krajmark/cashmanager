package com.krajmark.cashmanager.service;

import com.krajmark.cashmanager.dto.RegisterFormUserDTO;
import com.krajmark.cashmanager.mapper.UserMapper;
import com.krajmark.cashmanager.model.BaseUser;
import com.krajmark.cashmanager.repository.BaseUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final BaseUserRepo baseUserRepo;
    private final PasswordEncoder passwordEncoder;

    public UserManagementServiceImpl(BaseUserRepo baseUserRepo, PasswordEncoder passwordEncoder) {
        this.baseUserRepo = baseUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(RegisterFormUserDTO userDTO) {

        BaseUser userTemp = UserMapper.INSTANCE.registrationUserDtoToUserModel(userDTO);
        userTemp.setPassword(this.passwordEncoder.encode(userDTO.password()));
        this.baseUserRepo.save(userTemp);
        Optional<BaseUser> savedUser = this.baseUserRepo.findBaseUserByUsername(userDTO.username());
        return savedUser.isPresent();
    }

    @Override
    public boolean userAlreadyExists(RegisterFormUserDTO userDTO) {
        Optional<BaseUser> userOptional = this.baseUserRepo.findBaseUserByUsername(userDTO.username());
        return userOptional.isPresent();
    }
}
