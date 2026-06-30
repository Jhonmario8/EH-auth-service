package com.sp.ehauthservice.application.handler;

import com.sp.ehauthservice.application.dto.UserDTO;
import com.sp.ehauthservice.application.mapper.IUserMapper;
import com.sp.ehauthservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandler implements  IUserHandler{

    private final IUserServicePort userServicePort;
    private final IUserMapper userMapper;

    @Override
    public void createOrganizer(UserDTO userDTO) {
        userServicePort.createOrganizer(userMapper.toDomain(userDTO));
    }

    @Override
    public void createClient(UserDTO userDTO) {
        userServicePort.createClient(userMapper.toDomain(userDTO));
    }
}
