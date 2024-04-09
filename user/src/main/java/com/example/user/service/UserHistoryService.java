package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.entity.UserHistoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserHistoryService extends IService<UserHistoryEntity> {
    List<UserHistoryEntity> selectByUserName(String username);
    int insert(String userName,String loginTime,String ip);

    UserHistoryEntity selectBeforeLogin();
}
