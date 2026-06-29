package com.sp.ehauthservice.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sp.ehauthservice.application.constants.ApplicationConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank(message = ApplicationConstants.NAME_CANNOT_BE_BLANK)
    private String name;
    @NotBlank(message = ApplicationConstants.EMAIL_CANNOT_BE_BLANK)
    private String email;
    @NotBlank(message = ApplicationConstants.PHONE_CANNOT_BE_BLANK)
    private String phone;
    @NotBlank(message = ApplicationConstants.PASSWORD_CANNOT_BE_BLANK)
    private String password;


}
