package com.sp.ehauthservice.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sp.ehauthservice.application.constants.ApplicationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, max = 100, message = ApplicationConstants.NAME_SIZE_CONSTRAINT)
    private String name;
    @NotBlank(message = ApplicationConstants.EMAIL_CANNOT_BE_BLANK)
    @Size(max = 150, message = ApplicationConstants.EMAIL_SIZE_CONSTRAINT)
    @Email(message = ApplicationConstants.EMAIL_INVALID_FORMAT)
    private String email;
    @NotBlank(message = ApplicationConstants.PHONE_CANNOT_BE_BLANK)
    @Size(min = 7, max = 20, message = ApplicationConstants.PHONE_SIZE_CONSTRAINT)
    private String phone;
    @NotBlank(message = ApplicationConstants.PASSWORD_CANNOT_BE_BLANK)
    @Size(min = 8, message = ApplicationConstants.PASSWORD_SIZE_CONSTRAINT)
    private String password;


}
