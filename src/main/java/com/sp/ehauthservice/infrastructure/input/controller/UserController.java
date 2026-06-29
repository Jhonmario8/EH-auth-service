package com.sp.ehauthservice.infrastructure.input.controller;

import com.sp.ehauthservice.application.dto.UserDTO;
import com.sp.ehauthservice.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserHandler userHandler;

    @PostMapping("/organizer")
    public ResponseEntity<Void> createOrganizer(@RequestBody UserDTO userDTO) {
        userHandler.createOrganizer(userDTO);
        return ResponseEntity.ok().build();
    }

}
