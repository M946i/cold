package com.example.user.entity;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table("user_history")
@Data
@EntityScan
public class UserHistoryEntity {
    @Column("id")
    Integer id;
    @Column("username")
    String username;
    @Column("login_time")
    Timestamp login_time;
    @Column("ip")
    String ip;

}
