package com.krajmark.cashmanager.service;

import com.krajmark.cashmanager.dto.RegisterFormUserDTO;

public interface UserManagementService {

    boolean registerUser(RegisterFormUserDTO userDTO);

    boolean userAlreadyExists(RegisterFormUserDTO userDTO);
}
