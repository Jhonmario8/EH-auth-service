package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.LoginRequest;
import com.sp.ehauthservice.application.dto.LoginResponse;

public interface IAuthHandler {

    LoginResponse login(LoginRequest loginRequest);
}
