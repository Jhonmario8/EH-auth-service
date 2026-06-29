package com.sp.ehauthservice.domain.model;

import com.sp.ehauthservice.domain.api.IPasswordServicePort;
import com.sp.ehauthservice.domain.constants.DomainConstants;
import com.sp.ehauthservice.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private static final String CELLPHONE_PATTERN = "^\\+?\\d{3,}$";


    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Role role;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();


    public void encodePassword(IPasswordServicePort passwordServicePort){
        this.password = passwordServicePort.encodePassword(this.password);
    }

    public void validate(){
        if (!this.phone.matches(CELLPHONE_PATTERN)){
            throw new DomainException(DomainConstants.INVALID_CELLPHONE_NUMBER);
        }

    }

}
