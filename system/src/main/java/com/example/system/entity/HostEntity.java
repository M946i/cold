package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table("host")
@Data
@EntityScan
public class HostEntity {
    @Id("id")
    private Integer id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("host_name")
    private String host_name;
    @Column("host_number")
    private String host_number;
    @Column("host_status")
    private String host_status;
    @Column("create_time")
    private Timestamp create_time;
    @Column("update_time")
    private Timestamp update_time;
}