package com.example.user.dao;


import com.example.user.entity.UserHistoryEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserHistoryDao extends BaseMapper<UserHistoryEntity> {
    @Select("select * from user_history where username=#{username}" )
    List<UserHistoryEntity> selectByUserName(String username);

    @Insert("insert into user_history(username,login_time,ip) value(#{username},#{login_time},#{ip})")
    int insertUserHistory(String username,String login_time,String ip);

    @Select("SELECT id, username, DATE_FORMAT(login_time, '%Y-%m-%d %H:%i:%s') as loginTime ,ip "
            + "FROM user_history "
            + "WHERE id = (SELECT id FROM user_history order by id desc limit 2,1)")
    UserHistoryEntity selectBeforeLogin();
}
