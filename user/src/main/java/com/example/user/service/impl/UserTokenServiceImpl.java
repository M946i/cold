package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.dao.UserTokenDao;
import com.example.user.entity.UserTokenEntity;
import com.example.user.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenDao, UserTokenEntity> implements UserTokenService {
    @Autowired
    UserTokenDao userTokenDao;

    @Override
    public UserTokenEntity getUserTokenByUserName(String username) {
        return userTokenDao.getUserToken(username);
    }

    @Override
    public int loadUserToken(String username , String token, String expireTime, String updateTime) {
        return userTokenDao.loadUserToken(username, token, expireTime, updateTime);
    }

    @Override
    public UserTokenEntity getUserTokenExpireTimeByToken(String token) {
        return userTokenDao.getUserTokenExpireTimeByToken(token);
    }

    @Override
    public int reloadUserToken( String token, String expireTime, String updateTime,String username) {
        return userTokenDao.reloadUserToken(token, expireTime, updateTime,username);
    }

    @Override
    public void setUserTokenExpireTimeByToken(String token, String expireTime) {
        userTokenDao.setUserTokenExpireTimeByToken(token, expireTime);
    }


}
