package com.example.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.system.entity.WarehouseEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface WarehouseDao extends BaseMapper<WarehouseEntity> {
    @Select("select * from warehouse")
    List<WarehouseEntity> getAllWarehouse();
    @Insert("insert into warehouse(company_number,warehouse_number,warehouse_name,warehouse_manager_name,warehouse_manager_phone,warehouse_size,warehouse_address,warehouse_type,latitude,longitude) " +
            "value (#{company_number},#{warehouse_number},#{warehouse_name},#{warehouse_manager_name},#{warehouse_manager_phone},#{warehouse_size},#{warehouse_address},#{warehouse_type},#{latitude},#{longitude})")
    int insert(String company_number,String warehouse_number, String warehouse_name, String warehouse_manager_name, String warehouse_manager_phone, String warehouse_size, String warehouse_address, String warehouse_type, BigDecimal latitude, BigDecimal longitude);
}
