package com.sp.ehauthservice.infrastructure.config;

import com.sp.ehauthservice.domain.api.IAuthenticationServicePort;
import com.sp.ehauthservice.domain.api.IPasswordServicePort;
import com.sp.ehauthservice.domain.api.IUserServicePort;
import com.sp.ehauthservice.domain.spi.IUserPersistencePort;
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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserServicePort userServicePort(IPasswordServicePort passwordServicePort){
        return new UserService(userPersistencePort,authenticationServicePort,passwordServicePort );
    }
}
