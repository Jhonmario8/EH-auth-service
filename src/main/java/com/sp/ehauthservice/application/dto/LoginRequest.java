package com.sp.ehauthservice.application.dto;

import com.sp.ehauthservice.application.constants.ApplicationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = ApplicationConstants.EMAIL_CANNOT_BE_BLANK)
    @Email(message = ApplicationConstants.EMAIL_INVALID_FORMAT)
    private String email;
    @NotBlank(message = ApplicationConstants.PASSWORD_CANNOT_BE_BLANK)
    private String password;

}
