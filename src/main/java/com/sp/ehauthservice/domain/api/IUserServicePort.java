package com.sp.ehauthservice.domain.api;

import com.sp.ehauthservice.domain.model.User;

public interface IUserServicePort {

    void createOrganizer(User user);
}
