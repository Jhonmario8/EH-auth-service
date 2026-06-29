package com.sp.ehauthservice.application.mapper;

import com.sp.ehauthservice.application.dto.UserDTO;
import com.sp.ehauthservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    User toDomain(UserDTO userDTO);

    UserDTO toDTO(User user);

}
