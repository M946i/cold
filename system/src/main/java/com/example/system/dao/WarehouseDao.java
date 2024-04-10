package com.example.system.dao;

import com.example.system.entity.WarehouseEntity;
import com.mybatisflex.core.BaseMapper;
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
    int insertWarehouse(String company_number,String warehouse_number, String warehouse_name, String warehouse_manager_name, String warehouse_manager_phone, String warehouse_size, String warehouse_address, String warehouse_type, BigDecimal latitude, BigDecimal longitude);
}
