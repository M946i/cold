package com.example.user.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table("user_token")
@Data
@EntityScan
public class UserTokenEntity {
    @Column("user_id")
    Integer user_id;
    @Column("username")
    String username;
    @Column("token")
    String token;
    @Column("expire_time")
    Timestamp expire_time;
    @Column("update_time")
    Timestamp update_time;

}
