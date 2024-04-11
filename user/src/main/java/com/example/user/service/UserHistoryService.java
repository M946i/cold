package com.example.user.service;


import com.example.user.entity.UserHistoryEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface UserHistoryService extends IService<UserHistoryEntity> {
    List<UserHistoryEntity> selectByUserName(String username);
    int insertUserHistory(String username, Timestamp login_time, String ip);

    UserHistoryEntity selectBeforeLogin();
}
