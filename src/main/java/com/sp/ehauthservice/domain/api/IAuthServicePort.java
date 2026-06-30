package com.sp.ehauthservice.domain.api;

import com.sp.ehauthservice.domain.model.Auth;

public interface IAuthServicePort {

    Auth login(Auth auth);

}
