package com.sp.ehauthservice.infrastructure.output.jpa.adapter;

import com.sp.ehauthservice.domain.constants.DomainConstants;
import com.sp.ehauthservice.domain.exception.NotFoundException;
import com.sp.ehauthservice.domain.model.User;
import com.sp.ehauthservice.domain.spi.IUserPersistencePort;
import com.sp.ehauthservice.infrastructure.output.jpa.entity.RoleEntity;
import com.sp.ehauthservice.infrastructure.output.jpa.entity.UserEntity;
import com.sp.ehauthservice.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.sp.ehauthservice.infrastructure.output.jpa.repository.IRoleRepository;
import com.sp.ehauthservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserEntityMapper mapper;
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        RoleEntity roleEntity = roleRepository.findByName(user.getRole())
                .orElseThrow(() -> new NotFoundException(DomainConstants.MSG_ROLE_NOT_FOUND + user.getRole().name()));

        UserEntity userEntity = mapper.toEntity(user);
        userEntity.setRoleEntity(roleEntity);
        return mapper.toDomain(userRepository.save(userEntity));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Boolean existByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
