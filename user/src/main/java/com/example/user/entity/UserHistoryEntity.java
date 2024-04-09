package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@TableName("user_history")
@EntityScan
@Getter
@Setter
public class UserHistoryEntity {
    @TableField("id")
    Integer id;
    @TableField("username")
    String username;
    @TableField("login_time")
    Timestamp login_time;
    @TableField("ip")
    String ip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHistoryEntity that = (UserHistoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(login_time, that.login_time) && Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, login_time, ip);
    }
    @Override
    public String toString() {
        return "UserHistoryEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", login_time='" + login_time + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
