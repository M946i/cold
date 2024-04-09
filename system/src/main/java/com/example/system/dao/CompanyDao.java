package com.example.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.system.entity.CompanyEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyDao extends BaseMapper<CompanyEntity> {
    @Select("select * from company")
    List<CompanyEntity> getAllCompany();
    @Insert("insert into company (company_name,company_number,company_manager_name,company_manager_phone,company_address,company_type) " +
            " value(#{company_name},#{company_number},#{company_manager_name},#{company_manager_phone},#{company_address},#{company_type})")
    int insert(String company_name, String company_number, String company_manager_name, String company_manager_phone,String company_address ,String company_type);
}
