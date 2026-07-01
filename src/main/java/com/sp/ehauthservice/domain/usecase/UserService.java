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
    public User createOrganizer(User user) {
       return createUser(user,Role.ORGANIZER);
    }

    @Override
    public User createClient(User user) {
        return createUser(user, Role.CLIENT);
    }

    private User createUser(User user, Role role){
        if (role.equals(Role.ORGANIZER)) {
            validateRole(DomainConstants.MSG_ONLY_ADMIN_CAN_CREATE_ORGANIZER);
        } else {
            validateRole(DomainConstants.MSG_ONLY_ADMIN_CAN_CREATE_CLIENT);
        }
        validateUniqueness(user);
        user.setRole(role);
        user.encodePassword(passwordServicePort);
        user.validate();
        User userResponse = userPersistencePort.saveUser(user);
        userResponse.setPassword(null);
        return userResponse;
    }


    private void validateRole(String errorMessage) {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != Role.ADMIN) {
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
