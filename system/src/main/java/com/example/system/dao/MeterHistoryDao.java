package com.example.system.dao;

import com.example.system.entity.MeterHistoryEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MeterHistoryDao extends BaseMapper<MeterHistoryEntity> {
    @Select("SELECT * FROM meter_history WHERE DATE(create_time) = (SELECT DATE(MAX(create_time)) FROM meter_history)")
    List<MeterHistoryEntity> selectLastDayMeterHistory();
    @Select("select * from meter_history")
    List<MeterHistoryEntity> getValues();
    @Select("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'meter_history' ORDER BY ORDINAL_POSITION")
    String[] getHead();

    @Insert("insert into meter_history(meter_id, company_number, warehouse_number, host_number, min_temperature, max_temperature, current_temperature, min_humidity, max_humidity, current_humidity, meter_status, create_time) value (#{meter_id}, #{company_number}, #{warehouse_number}, #{host_number}, #{min_temperature}, #{max_temperature}, #{current_temperature}, #{min_humidity}, #{max_humidity}, #{current_humidity}, #{meter_status}, #{create_time})")
    int addMeterHistory(MeterHistoryEntity meterHistoryEntity);

}
