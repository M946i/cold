package com.example.user.service.impl;


import com.example.user.dao.UserHistoryDao;
import com.example.user.entity.UserHistoryEntity;
import com.example.user.service.UserHistoryService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
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
    public int insertUserHistory(String userName,String login_time,String ip) {
        return userHistoryDao.insertUserHistory(userName,login_time,ip);
    }

    @Override
    public UserHistoryEntity selectBeforeLogin() {
        return userHistoryDao.selectBeforeLogin();
    }
}
