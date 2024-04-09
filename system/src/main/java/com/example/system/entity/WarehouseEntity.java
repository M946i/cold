package com.example.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@TableName(value = "warehouse", autoResultMap = true)
@Getter
@Setter
@EntityScan
public class WarehouseEntity {
    @TableId("id")
    private Integer id;
    @TableField("company_number")
    private String company_number;
    @TableField("warehouse_name")
    private String warehouse_name;
    @TableField("warehouse_number")
    private String warehouse_number;
    @TableField("warehouse_manager_name")
    private String warehouse_manager_name;
    @TableField("warehouse_manager_phone")
    private String warehouse_manager_phone;
    @TableField("warehouse_size")
    private String warehouse_size;
    @TableField("warehouse_address")
    private String warehouse_address;
    @TableField("warehouse_type")
    private String warehouse_type;
    @TableField("warehouse_status")
    private String warehouse_status;
    @TableField("latitude")
    private BigDecimal latitude;
    @TableField("longitude")
    private BigDecimal longitude;
    @TableField("create_time")
    private Timestamp create_time;
    @TableField("update_time")
    private Timestamp update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(company_number, that.company_number) && Objects.equals(warehouse_name, that.warehouse_name) && Objects.equals(warehouse_number, that.warehouse_number) && Objects.equals(warehouse_manager_name, that.warehouse_manager_name) && Objects.equals(warehouse_manager_phone, that.warehouse_manager_phone) && Objects.equals(warehouse_size, that.warehouse_size) && Objects.equals(warehouse_address, that.warehouse_address) && Objects.equals(warehouse_type, that.warehouse_type) && Objects.equals(warehouse_status, that.warehouse_status) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(create_time, that.create_time) && Objects.equals(update_time, that.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company_number, warehouse_name, warehouse_number, warehouse_manager_name, warehouse_manager_phone, warehouse_size, warehouse_address, warehouse_type, warehouse_status, latitude, longitude, create_time, update_time);
    }

    @Override
    public String toString() {
        return "WarehouseEntity{" +
                "id=" + id +
                ", company_number='" + company_number + '\'' +
                ", warehouse_name='" + warehouse_name + '\'' +
                ", warehouse_number='" + warehouse_number + '\'' +
                ", warehouse_manager_name='" + warehouse_manager_name + '\'' +
                ", warehouse_manager_phone='" + warehouse_manager_phone + '\'' +
                ", warehouse_size='" + warehouse_size + '\'' +
                ", warehouse_address='" + warehouse_address + '\'' +
                ", warehouse_type='" + warehouse_type + '\'' +
                ", warehouse_status='" + warehouse_status + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
