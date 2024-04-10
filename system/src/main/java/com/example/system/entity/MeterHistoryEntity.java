package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Table("meter_history")
@Data
@EntityScan
public class MeterHistoryEntity {
    @Id("id")
    private Long id;
    @Column("meter_id")
    private Integer meter_id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("host_number")
    private String host_number;
    @Column("min_temperature")
    private Double min_temperature;
    @Column("max_temperature")
    private Double max_temperature;
    @Column("current_temperature")
    private Double current_temperature;
    @Column("min_humidity")
    private Double min_humidity;
    @Column("min_humidity")
    private Double max_humidity;
    @Column("current_humidity")
    private Double current_humidity;
    @Column("meter_status")
    private String meter_status;
    @Column("create_time")
    private Timestamp create_time;
}
