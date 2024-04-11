package com.example.system.dao;

import com.example.system.entity.MeterEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface MeterDao extends BaseMapper<MeterEntity> {
    @Select("select * from meter")
    List<MeterEntity> getAllMeter();
    @Insert("insert into meter(company_number, warehouse_number, host_number, meter_number, min_temperature, max_temperature, min_humidity, max_humidity) value (#{company_number}, #{warehouse_number}, #{host_number}, #{meter_number}, #{min_temperature}, #{max_temperature}, #{min_humidity}, #{max_humidity})")
    int insertMeter(String company_number, String warehouse_number, String host_number, String meter_number, Double min_temperature, Double max_temperature, Double min_humidity, Double max_humidity);
    @Delete("delete from meter where meter_number = #{meter_number}")
    int deleteMeterByMeter_number(String meter_number);
    @Update("UPDATE meter "
            + "SET company_number = #{company_number}, "
            + "warehouse_number = #{warehouse_number}, "
            + "host_number = #{host_number}, "
            + "meter_number = #{meter_number}, "
            + "min_temperature = #{min_temperature}, "
            + "max_temperature = #{max_temperature}, "
            + "min_humidity = #{min_humidity}, "
            + "max_humidity = #{max_humidity}, "
            + "meter_status = #{meter_status}, "
            + "update_time = #{update_time} "
            + "WHERE id = #{id}")
    int updateMeterById(@Param("id") Integer id,
                        @Param("company_number") String company_number,
                        @Param("warehouse_number") String warehouse_number,
                        @Param("host_number") String host_number,
                        @Param("meter_number") String meter_number,
                        @Param("min_temperature") Double min_temperature,
                        @Param("max_temperature") Double max_temperature,
                        @Param("min_humidity") Double min_humidity,
                        @Param("max_humidity") Double max_humidity,
                        @Param("meter_status") String meter_status,
                        @Param("update_time") Timestamp update_time);

}