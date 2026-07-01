package com.sp.ehauthservice.domain.spi;

import com.sp.ehauthservice.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {

    User saveUser(User user);
    Optional<User> findByEmail(String email);
    Boolean existByPhone(String phone);


}
