package com.sp.ehauthservice.domain.api;

import com.sp.ehauthservice.domain.model.User;

public interface IUserServicePort {

    User createOrganizer(User user);
    User createClient(User user);
}
