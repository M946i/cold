package com.example.user.service.impl;


import com.example.user.dao.UserTokenDao;
import com.example.user.entity.UserTokenEntity;
import com.example.user.service.UserTokenService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
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
    public int loadUserToken(String username, String token, String expire_time, String update_time) {
        return userTokenDao.loadUserToken(username, token, expire_time, update_time);
    }

    @Override
    public UserTokenEntity getUserTokenExpireTimeByToken(String token) {
        return userTokenDao.getUserTokenExpireTimeByToken(token);
    }

    @Override
    public int reloadUserToken(String token, String expire_time, String update_time, String username) {
        return userTokenDao.reloadUserToken(token, expire_time, update_time, username);
    }

    @Override
    public void setUserTokenExpireTimeByToken(String token, String expire_time) {
        userTokenDao.setUserTokenExpireTimeByToken(token, expire_time);
    }


}
