package com.example.user.dao;


import com.example.user.entity.UserEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    @Select("SELECT * FROM user WHERE username = #{username}")
    UserEntity selectByUserName(String username);

}
