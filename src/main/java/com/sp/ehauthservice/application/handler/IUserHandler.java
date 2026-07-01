package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.UserDTO;



public interface IUserHandler {
    UserDTO createOrganizer(UserDTO userDTO);
    UserDTO createClient(UserDTO userDTO);
}
