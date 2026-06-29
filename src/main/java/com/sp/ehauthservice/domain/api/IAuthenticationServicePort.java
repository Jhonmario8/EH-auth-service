package com.sp.ehauthservice.domain.api;

import com.sp.ehauthservice.domain.model.Role;

public interface IAuthenticationServicePort {

    Role getCurrentUserRole();

}
