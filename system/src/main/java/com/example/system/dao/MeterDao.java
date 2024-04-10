package com.example.system.dao;

import com.example.system.entity.MeterEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MeterDao extends BaseMapper<MeterEntity> {
    @Select("select * from meter")
    List<MeterEntity> getAllMeter();
    @Insert("insert into meter(company_number, warehouse_number, host_number, meter_number, min_temperature, max_temperature, min_humidity, max_humidity) value (#{company_number}, #{warehouse_number}, #{host_number}, #{meter_number}, #{min_temperature}, #{max_temperature}, #{min_humidity}, #{max_humidity})")
    int insertMeter(String company_number, String warehouse_number, String host_number, String meter_number, Double min_temperature, Double max_temperature, Double min_humidity, Double max_humidity);
}
