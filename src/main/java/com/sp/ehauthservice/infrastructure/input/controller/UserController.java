package com.sp.ehauthservice.infrastructure.input.controller;

import com.sp.ehauthservice.application.dto.UserDTO;
import com.sp.ehauthservice.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<UserDTO> createOrganizer(@Validated @RequestBody UserDTO userDTO) {
         UserDTO dto = userHandler.createOrganizer(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/client")
    public ResponseEntity<UserDTO> createClient(@Validated @RequestBody UserDTO userDTO) {
        UserDTO dto = userHandler.createClient(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

}
