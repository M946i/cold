package com.example.system.dao;

import com.example.system.entity.HostEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostDao extends BaseMapper<HostEntity> {
    @Select("select * from host")
    List<HostEntity> getAllHost();
    @Insert("insert into host(company_number, warehouse_number, host_name, host_number) value (#{company_number}, #{warehouse_number}, #{host_name}, #{host_number})")
    int insertHost(String company_number, String warehouse_number, String host_name, String host_number);
}
