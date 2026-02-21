package com.example.pruebanuevaeps.service.auth;

import com.example.pruebanuevaeps.dto.auth.LoginRequest;
import com.example.pruebanuevaeps.dto.auth.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    String login(LoginRequest request);
}
