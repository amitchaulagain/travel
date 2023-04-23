package com.travel.service;

import com.travel.model.dto.AppClientSignUpDto;
import com.travel.model.dto.BusinessRegisterDto;
import com.travel.model.entities.AppClient;
import com.travel.model.entities.BusinessOwner;
import com.travel.model.entities.Hobby;
import com.travel.model.entities.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> seedUsersAndUserRoles();

    AppClient register(AppClientSignUpDto user);

    BusinessOwner registerBusiness(BusinessRegisterDto business);

    BusinessOwner saveUpdatedUser(BusinessOwner businessOwner);

    AppClient saveUpdatedUserClient(AppClient appClient);

    UserEntity findUserById(Long userId);

    UserEntity findUserByEmail(String email);

    boolean deleteUser(Long id);

    BusinessOwner findBusinessOwnerById(Long id);

    UserEntity findUserByUsername(String username);

    boolean userExists(String username, String email);

    void saveUserWithUpdatedPassword(UserEntity userEntity);

    AppClient findAppClientById(Long clientId);

    void findAndRemoveHobbyFromClientsRecords(Hobby hobby);
    
    boolean businessExists(String businessName);

    AppClient findAppClientByUsername(String username);

    BusinessOwner findBusinessByUsername(String username);
}


