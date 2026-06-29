package com.sp.ehauthservice.domain.model;

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

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Role role;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

}
