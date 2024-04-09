package com.example.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@TableName(value = "company", autoResultMap = true)
@Getter
@Setter
@EntityScan
public class CompanyEntity {
    @TableId("id")
    private Integer id;
    @TableField("company_name")
    private String company_name;
    @TableField("company_number")
    private String company_number;
    @TableField("company_manager_name")
    private String company_manager_name;
    @TableField("company_manager_phone")
    private String company_manager_phone;
    @TableField("company_address")
    private String company_address;
    @TableField("company_type")
    private String company_type;
    @TableField("create_time")
    private Timestamp create_time;
    @TableField("update_time")
    private Timestamp update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(company_name, that.company_name) && Objects.equals(company_number, that.company_number) && Objects.equals(company_manager_name, that.company_manager_name) && Objects.equals(company_manager_phone, that.company_manager_phone) && Objects.equals(company_address, that.company_address) && Objects.equals(company_type, that.company_type) && Objects.equals(create_time, that.create_time) && Objects.equals(update_time, that.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company_name, company_number, company_manager_name, company_manager_phone, company_address, company_type, create_time, update_time);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", company_number='" + company_number + '\'' +
                ", company_manager_name='" + company_manager_name + '\'' +
                ", company_manager_phone='" + company_manager_phone + '\'' +
                ", company_address='" + company_address + '\'' +
                ", company_type='" + company_type + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
