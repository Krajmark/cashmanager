package com.krajmark.cashmanager.service;

import com.krajmark.cashmanager.requests.SignupRequest;

public interface UserService {
    String register(SignupRequest signupRequest);
}
