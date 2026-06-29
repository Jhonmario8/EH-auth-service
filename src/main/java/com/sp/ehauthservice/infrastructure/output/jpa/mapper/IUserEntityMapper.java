package com.sp.ehauthservice.infrastructure.output.jpa.mapper;

import com.sp.ehauthservice.domain.model.User;
import com.sp.ehauthservice.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserEntityMapper {

    @Mapping(target = "role", source = "roleEntity.name")
    User toDomain(UserEntity userEntity);

    @Mapping(target = "roleEntity.name", source = "role")
    UserEntity toEntity(User user);

}
