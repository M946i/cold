package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.dao.UserHistoryDao;
import com.example.user.entity.UserHistoryEntity;
import com.example.user.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryDao, UserHistoryEntity> implements UserHistoryService {
    @Autowired
    UserHistoryDao userHistoryDao;
    @Override
    public List<UserHistoryEntity> selectByUserName(String username) {
        return userHistoryDao.selectByUserName(username);
    }

    @Override
    public int insert(String userName,String loginTime,String ip) {
        return userHistoryDao.insert(userName,loginTime,ip);
    }

    @Override
    public UserHistoryEntity selectBeforeLogin() {
        return userHistoryDao.selectBeforeLogin();
    }
}
