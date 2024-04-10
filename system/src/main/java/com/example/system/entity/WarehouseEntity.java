package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Table("warehouse")
@Data
@EntityScan
public class WarehouseEntity {
    @Id("id")
    private Integer id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_name")
    private String warehouse_name;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("warehouse_manager_name")
    private String warehouse_manager_name;
    @Column("warehouse_manager_phone")
    private String warehouse_manager_phone;
    @Column("warehouse_size")
    private String warehouse_size;
    @Column("warehouse_address")
    private String warehouse_address;
    @Column("warehouse_type")
    private String warehouse_type;
    @Column("warehouse_status")
    private String warehouse_status;
    @Column("latitude")
    private BigDecimal latitude;
    @Column("longitude")
    private BigDecimal longitude;
    @Column("create_time")
    private Timestamp create_time;
    @Column("update_time")
    private Timestamp update_time;
}
