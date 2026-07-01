package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.UserDTO;
import com.sp.ehauthservice.application.mapper.IUserMapper;
import com.sp.ehauthservice.domain.api.IUserServicePort;
import com.sp.ehauthservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandler implements  IUserHandler{

    private final IUserServicePort userServicePort;
    private final IUserMapper userMapper;

    @Override
    public UserDTO createOrganizer(UserDTO userDTO) {
        User user = userServicePort.createOrganizer(userMapper.toDomain(userDTO));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO createClient(UserDTO userDTO) {
       User user = userServicePort.createClient(userMapper.toDomain(userDTO));
       return userMapper.toDTO(user);
    }
}
