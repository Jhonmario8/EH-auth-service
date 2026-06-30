package com.sp.ehauthservice.domain.usecase;

import com.sp.ehauthservice.domain.api.IAuthenticationServicePort;
import com.sp.ehauthservice.domain.api.IPasswordServicePort;
import com.sp.ehauthservice.domain.api.IUserServicePort;
import com.sp.ehauthservice.domain.constants.DomainConstants;
import com.sp.ehauthservice.domain.exception.ConflictException;
import com.sp.ehauthservice.domain.exception.ForbiddenException;
import com.sp.ehauthservice.domain.model.Role;
import com.sp.ehauthservice.domain.model.User;
import com.sp.ehauthservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final IPasswordServicePort passwordServicePort;

    @Override
    public void createOrganizer(User user) {
        validateRole(Role.ADMIN, DomainConstants.MSG_ONLY_ADMIN_CAN_CREATE_ORGANIZER);
        validateUniqueness(user);
        user.setRole(Role.ORGANIZER);
        user.encodePassword(passwordServicePort);
        user.validate();
        userPersistencePort.saveUser(user);
    }

    @Override
    public void createClient(User user) {
        validateRole(Role.ADMIN, DomainConstants.MSG_ONLY_ADMIN_CAN_CREATE_CLIENT);
        validateUniqueness(user);
        user.setRole(Role.CLIENT);
        user.encodePassword(passwordServicePort);
        user.validate();
        userPersistencePort.saveUser(user);
    }


    private void validateRole(Role requiredRole, String errorMessage) {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != requiredRole) {
            throw new ForbiddenException(errorMessage);
        }
    }

    private void validateUniqueness(User user) {
        userPersistencePort.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new ConflictException(DomainConstants.MSG_EMAIL_ALREADY_EXISTS);
        });

        if (userPersistencePort.existByPhone(user.getPhone())) {
            throw new ConflictException(DomainConstants.MSG_PHONE_NUMBER_ALREADY_EXISTS);
        }
    }
}
