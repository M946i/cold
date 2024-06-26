package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table("meter")
@Data
@EntityScan
public class MeterEntity {
    @Id("id")
    private Integer id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("host_number")
    private String host_number;
    @Column("meter_number")
    private String meter_number;
    @Column("min_temperature")
    private Double min_temperature;
    @Column("max_temperature")
    private Double max_temperature;
    @Column("min_humidity")
    private Double min_humidity;
    @Column("max_humidity")
    private Double max_humidity;
    @Column("meter_status")
    private String meter_status;
    @Column("create_time")
    private Timestamp create_time;
    @Column("update_time")
    private Timestamp update_time;
}
