package com.travel.model.repostiory;

import com.travel.model.entities.UserRoleEntity;
import com.travel.model.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum roleEnum);
}
