package com.travel.service;

import com.travel.model.entities.UserRoleEntity;
import com.travel.model.entities.enums.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum);

    UserRoleEntity saveRole(UserRoleEntity userRoleEntity);
}
