package com.example.system.dao;

import com.example.system.entity.HostHistoryEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostHistoryDao extends BaseMapper<HostHistoryEntity> {
    @Select("SELECT * FROM host_history WHERE DATE(create_time) = (SELECT DATE(MAX(create_time)) FROM host_history)")
    List<HostHistoryEntity> selectLastDayHostHistory();
    @Select("select * from host_history")
    List<HostHistoryEntity> getValues();

    @Select("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'host_history' ORDER BY ORDINAL_POSITION")
    String[] getHead();

    @Insert("insert into host_history(host_id, company_number, warehouse_number, host_name, host_number, host_status,create_time) value (#{host_id}, #{company_number}, #{warehouse_number}, #{host_name}, #{host_number}, #{host_status},#{create_time})")
    int addHostHistory(HostHistoryEntity hostHistoryEntity);
}
