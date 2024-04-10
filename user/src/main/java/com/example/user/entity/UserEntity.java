package com.example.user.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Table("user")
@Data
@EntityScan
public class UserEntity {
    @Id("id")
    private Integer id;
    private String username;
    private String password;

}
