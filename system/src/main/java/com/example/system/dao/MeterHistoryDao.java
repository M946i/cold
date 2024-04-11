package com.example.system.dao;

import com.example.system.entity.MeterHistoryEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MeterHistoryDao extends BaseMapper<MeterHistoryEntity> {
    @Select("SELECT * FROM meter_history WHERE create_time >= CURDATE() - INTERVAL 1 DAY AND create_time < CURDATE()")
    List<MeterHistoryEntity> selectLastDayMeterHistory();
}
