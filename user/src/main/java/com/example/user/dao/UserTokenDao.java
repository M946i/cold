package com.example.user.dao;


import com.example.user.entity.UserTokenEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserTokenDao extends BaseMapper<UserTokenEntity> {
    @Insert("insert into user_token(username,token,expire_time,update_time) value (#{username},#{token},#{expire_time},#{update_time})")
    int loadUserToken(String username, String token, String expire_time, String update_time);

    @Select("select user_id, username,token,DATE_FORMAT(expire_time, '%Y-%m-%d %H:%i:%s') as expire_time,DATE_FORMAT(update_time, '%Y-%m-%d %H:%i:%s') as update_time from user_token where username=#{username}")
    UserTokenEntity getUserToken(String username);

    @Update("update user_token set token=#{token},expire_time=#{expire_time},update_time=#{update_time} where username=#{username}")
    int reloadUserToken(String token, String expire_time, String update_time, String username);

    @Update("update user_token set expire_time=#{expire_time} where token=#{token}")
    int setUserTokenExpireTimeByToken(String token, String expire_time);

    @Select("select user_id, username,token,DATE_FORMAT(expire_time, '%Y-%m-%d %H:%i:%s') as expire_time,DATE_FORMAT(update_time, '%Y-%m-%d %H:%i:%s') as update_time from user_token where token=#{token}")
    UserTokenEntity getUserTokenExpireTimeByToken(String token);
}
