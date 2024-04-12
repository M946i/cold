package com.example.user.service.impl;


import com.example.user.dao.UserDao;
import com.example.user.entity.UserEntity;
import com.example.user.service.UserService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    UserDao coldDao;

    @Override
    public UserEntity selectByUserName(String username) {
        // 使用父类的baseMapper方法获取ColdDao的代理对象

        // 将ColdEntity对象转换为字符串并返回
        return coldDao.selectByUserName(username);
    }
}
