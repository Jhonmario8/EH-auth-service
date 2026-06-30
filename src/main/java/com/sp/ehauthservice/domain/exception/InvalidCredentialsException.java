package com.sp.ehauthservice.domain.exception;

import com.sp.ehauthservice.domain.constants.DomainConstants;

public class InvalidCredentialsException extends DomainException{

    public InvalidCredentialsException() {
        super(DomainConstants.MSG_INVALID_CREDENTIALS);
    }
}
