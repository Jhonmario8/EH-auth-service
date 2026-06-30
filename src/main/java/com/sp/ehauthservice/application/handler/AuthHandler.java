package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.LoginRequest;
import com.sp.ehauthservice.application.dto.LoginResponse;
import com.sp.ehauthservice.domain.api.IAuthServicePort;
import com.sp.ehauthservice.domain.model.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandler implements IAuthHandler {

    private final IAuthServicePort authServicePort;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Auth auth = new Auth();
        auth.setEmail(loginRequest.getEmail());
        auth.setPassword(loginRequest.getPassword());

        Auth authResult = authServicePort.login(auth);

        LoginResponse response = new LoginResponse();
        response.setToken(authResult.getToken());

        return response;
    }
}
