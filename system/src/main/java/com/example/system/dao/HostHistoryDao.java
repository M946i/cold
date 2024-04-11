package com.example.system.dao;

import com.example.system.entity.HostHistoryEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostHistoryDao extends BaseMapper<HostHistoryEntity>{
    @Select("SELECT * FROM host_history WHERE create_time >= CURDATE() - INTERVAL 1 DAY AND create_time < CURDATE()")
    List<HostHistoryEntity> selectLastDayHostHistory();
}
