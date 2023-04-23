package com.travel.service;

import com.travel.model.entities.UserEntity;
import org.springframework.scheduling.annotation.Async;

public interface NotificationService {
    @Async
    void sendNotification(UserEntity userEntity);
}
