package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table( "company")
@Data
@EntityScan
public class CompanyEntity {
    @Id("id")
    private Integer id;
    @Column("company_name")
    private String company_name;
    @Column("company_number")
    private String company_number;
    @Column("company_manager_name")
    private String company_manager_name;
    @Column("company_manager_phone")
    private String company_manager_phone;
    @Column("company_address")
    private String company_address;
    @Column("company_type")
    private String company_type;
    @Column("create_time")
    private Timestamp create_time;
    @Column("update_time")
    private Timestamp update_time;
}
