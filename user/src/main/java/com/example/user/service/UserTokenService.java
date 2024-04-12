package com.example.user.service;


import com.example.user.entity.UserTokenEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface UserTokenService extends IService<UserTokenEntity> {
    UserTokenEntity getUserTokenByUserName(String username);

    int loadUserToken(String username, String token, String expireTime, String updateTime);

    UserTokenEntity getUserTokenExpireTimeByToken(String token);

    int reloadUserToken(String token, String expireTime, String updateTime, String username);

    void setUserTokenExpireTimeByToken(String token, String expireTime);
}
