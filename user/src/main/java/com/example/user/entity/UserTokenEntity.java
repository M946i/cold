package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@TableName("user_token")
@EntityScan
@Getter
@Setter
public class UserTokenEntity {
    @TableField("user_id")
    Integer user_id;
    @TableField("username")
    String username;
    @TableField("token")
    String token;
    @TableField("expire_time")
    Timestamp expire_time;
    @TableField("update_time")
    Timestamp update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTokenEntity that = (UserTokenEntity) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(username, that.username) && Objects.equals(token, that.token) && Objects.equals(expire_time, that.expire_time) && Objects.equals(update_time, that.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, token, expire_time, update_time);
    }

    @Override
    public String toString() {
        return "UserTokenEntity{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", expire_time='" + expire_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
