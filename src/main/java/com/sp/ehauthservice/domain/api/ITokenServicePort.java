package com.sp.ehauthservice.domain.api;

import com.sp.ehauthservice.domain.model.User;

import java.util.Map;

public interface ITokenServicePort {

    String generateToken(User user);

    Map<String, Object> validateToken(String token);

}
