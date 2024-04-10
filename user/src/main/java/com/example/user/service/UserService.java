package com.example.user.service;


import com.example.user.entity.UserEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<UserEntity> {
    UserEntity selectByUserName(String username);
}
