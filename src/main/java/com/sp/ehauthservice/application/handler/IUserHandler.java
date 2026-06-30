package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.UserDTO;


public interface IUserHandler {
    void createOrganizer(UserDTO userDTO);
    void createClient(UserDTO userDTO);
}
