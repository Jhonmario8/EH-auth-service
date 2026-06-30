package com.sp.ehauthservice.domain.usecase;

import com.sp.ehauthservice.domain.api.IAuthServicePort;
import com.sp.ehauthservice.domain.api.IPasswordServicePort;
import com.sp.ehauthservice.domain.api.ITokenServicePort;
import com.sp.ehauthservice.domain.constants.DomainConstants;
import com.sp.ehauthservice.domain.exception.InvalidCredentialsException;
import com.sp.ehauthservice.domain.exception.UnauthorizedException;
import com.sp.ehauthservice.domain.model.Auth;
import com.sp.ehauthservice.domain.model.User;
import com.sp.ehauthservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthService implements IAuthServicePort {

    private final ITokenServicePort tokenServicePort;
    private final IUserPersistencePort userPersistencePort;
    private final IPasswordServicePort passwordServicePort;


    @Override
    public Auth login(Auth auth) {

        User user = userPersistencePort.findByEmail(auth.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if (!user.getActive()){
            throw new UnauthorizedException(DomainConstants.MSG_UNAUTHORIZED_USER);
        }
        if (passwordServicePort.matches(auth.getPassword(), user.getPassword())) {
            auth.setToken(tokenServicePort.generateToken(user));
            auth.setPassword(null);
            auth.setEmail(null);
            return auth;
        } else {
            throw new InvalidCredentialsException();
        }

    }



}
