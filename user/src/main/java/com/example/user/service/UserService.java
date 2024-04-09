package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<UserEntity> {
    UserEntity selectByUserName(String username);
}
