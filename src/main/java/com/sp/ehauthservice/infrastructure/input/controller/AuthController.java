package com.sp.ehauthservice.infrastructure.input.controller;

import com.sp.ehauthservice.application.dto.LoginRequest;
import com.sp.ehauthservice.application.dto.LoginResponse;
import com.sp.ehauthservice.application.handler.IAuthHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthHandler authHandler;

    @PostMapping("/login")
    public LoginResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        return authHandler.login(loginRequest);
    }

}
