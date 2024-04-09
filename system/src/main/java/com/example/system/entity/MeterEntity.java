package com.example.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@TableName(value = "meter", autoResultMap = true)
@Getter
@Setter
@EntityScan
public class MeterEntity {
    @TableId("id")
    private Integer id;
    @TableField("company_number")
    private String company_number;
    @TableField("warehouse_number")
    private String warehouse_number;
    @TableField("host_number")
    private String host_number;
    @TableField("meter_number")
    private String meter_number;
    @TableField("min_temperature")
    private Double min_temperature;
    @TableField("max_temperature")
    private Double max_temperature;
    @TableField("min_humidity")
    private Double min_humidity;
    @TableField("max_humidity")
    private Double max_humidity;
    @TableField("meter_status")
    private String meter_status;
    @TableField("create_time")
    private Timestamp create_time;
    @TableField("update_time")
    private Timestamp update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeterEntity that = (MeterEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(company_number, that.company_number) && Objects.equals(warehouse_number, that.warehouse_number) && Objects.equals(host_number, that.host_number) && Objects.equals(meter_number, that.meter_number) && Objects.equals(min_temperature, that.min_temperature) && Objects.equals(max_temperature, that.max_temperature) && Objects.equals(min_humidity, that.min_humidity) && Objects.equals(max_humidity, that.max_humidity) && Objects.equals(meter_status, that.meter_status) && Objects.equals(create_time, that.create_time) && Objects.equals(update_time, that.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company_number, warehouse_number, host_number, meter_number, min_temperature, max_temperature, min_humidity, max_humidity, meter_status, create_time, update_time);
    }

    @Override
    public String toString() {
        return "MeterEntity{" +
                "id=" + id +
                ", company_number='" + company_number + '\'' +
                ", warehouse_number='" + warehouse_number + '\'' +
                ", host_number='" + host_number + '\'' +
                ", meter_number='" + meter_number + '\'' +
                ", min_temperature=" + min_temperature +
                ", max_temperature=" + max_temperature +
                ", min_humidity=" + min_humidity +
                ", max_humidity=" + max_humidity +
                ", meter_status='" + meter_status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
