package com.sp.ehauthservice.infrastructure.config;

import com.sp.ehauthservice.domain.api.*;
import com.sp.ehauthservice.domain.spi.IUserPersistencePort;
import com.sp.ehauthservice.domain.usecase.AuthService;
import com.sp.ehauthservice.domain.usecase.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {

    private final IUserPersistencePort userPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final ITokenServicePort tokenServicePort;




    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserServicePort userServicePort(IPasswordServicePort passwordServicePort){
        return new UserService(userPersistencePort,authenticationServicePort,passwordServicePort );
    }

    @Bean
    public IAuthServicePort authServicePort(IPasswordServicePort passwordServicePort){
        return new AuthService(tokenServicePort,userPersistencePort,passwordServicePort);
    }
}
