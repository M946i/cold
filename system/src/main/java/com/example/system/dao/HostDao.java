package com.example.system.dao;

import com.example.system.entity.HostEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface HostDao extends BaseMapper<HostEntity> {
    @Select("select * from host")
    List<HostEntity> getAllHost();
    @Insert("insert into host(company_number, warehouse_number, host_name, host_number) value (#{company_number}, #{warehouse_number}, #{host_name}, #{host_number})")
    int insertHost(String company_number, String warehouse_number, String host_name, String host_number);
    @Delete("delete from host where host_number = #{host_number}")
    int deleteHostByHost_number(String host_number);
    @Update("UPDATE host "
            + "SET company_number = #{company_number}, "
            + "warehouse_number = #{warehouse_number}, "
            + "host_name = #{host_name}, "
            + "host_number = #{host_number}, "
            + "host_status = #{host_status}, "
            + "update_time = #{update_time} "
            + "WHERE id = #{id}")
    int updateHostById(@Param("id") Integer id,
                       @Param("company_number") String company_number,
                       @Param("warehouse_number") String warehouse_number,
                       @Param("host_name") String host_name,
                       @Param("host_number") String host_number,
                       @Param("host_status") String host_status,
                       @Param("update_time") Timestamp update_time);

}
