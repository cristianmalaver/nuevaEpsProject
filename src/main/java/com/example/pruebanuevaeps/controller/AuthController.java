package com.example.pruebanuevaeps.controller;

import com.example.pruebanuevaeps.dto.auth.LoginRequest;
import com.example.pruebanuevaeps.dto.auth.RegisterRequest;
import com.example.pruebanuevaeps.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }

}
