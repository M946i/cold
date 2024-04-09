package com.example.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@TableName(value = "host", autoResultMap = true)
@Getter
@Setter
@EntityScan
public class HostEntity {
    @TableId("id")
    private Integer id;
    @TableField("company_number")
    private String company_number;
    @TableField("warehouse_number")
    private String warehouse_number;
    @TableField("host_name")
    private String host_name;
    @TableField("host_number")
    private String host_number;
    @TableField("host_status")
    private String host_status;
    @TableField("create_time")
    private Timestamp create_time;
    @TableField("update_time")
    private Timestamp update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostEntity that = (HostEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(company_number, that.company_number) && Objects.equals(warehouse_number, that.warehouse_number) && Objects.equals(host_name, that.host_name) && Objects.equals(host_number, that.host_number) && Objects.equals(host_status, that.host_status) && Objects.equals(create_time, that.create_time) && Objects.equals(update_time, that.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company_number, warehouse_number, host_name, host_number, host_status, create_time, update_time);
    }

    @Override
    public String toString() {
        return "HostEntity{" +
                "id=" + id +
                ", company_number='" + company_number + '\'' +
                ", warehouse_number='" + warehouse_number + '\'' +
                ", host_name='" + host_name + '\'' +
                ", host_number='" + host_number + '\'' +
                ", host_status='" + host_status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}