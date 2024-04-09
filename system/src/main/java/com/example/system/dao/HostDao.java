package com.example.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.system.entity.HostEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostDao extends BaseMapper<HostEntity>{
    @Select("select * from host")
    List<HostEntity> getAllHost();
    @Insert("insert into host(company_number, warehouse_number, host_name, host_number) value (#{company_number}, #{warehouse_number}, #{host_name}, #{host_number})")
    int insert(String company_number, String warehouse_number, String host_name, String host_number);
}
