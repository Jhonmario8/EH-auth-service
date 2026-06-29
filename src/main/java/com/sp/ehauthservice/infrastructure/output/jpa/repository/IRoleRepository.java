package com.sp.ehauthservice.infrastructure.output.jpa.repository;

import com.sp.ehauthservice.domain.model.Role;
import com.sp.ehauthservice.infrastructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(Role name);


}
