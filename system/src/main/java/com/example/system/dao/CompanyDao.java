package com.example.system.dao;

import com.example.system.entity.CompanyEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyDao extends BaseMapper<CompanyEntity> {
    @Select("select * from company")
    List<CompanyEntity> getAllCompany();

    @Insert("insert into company (company_name,company_number,company_manager_name,company_manager_phone,company_address,company_type) " +
            " value(#{company_name},#{company_number},#{company_manager_name},#{company_manager_phone},#{company_address},#{company_type})")
    int insertCompany(String company_name, String company_number, String company_manager_name, String company_manager_phone, String company_address, String company_type);

    @Delete("delete from company where company_number = #{company_number}")
    int deleteCompanyByCompany_number(String company_number);

    @Update("UPDATE company SET company_name = #{company_name}, "
            + "company_number = #{company_number}, "
            + "company_manager_name = #{company_manager_name}, "
            + "company_manager_phone = #{company_manager_phone}, "
            + "company_address = #{company_address}, "
            + "company_type = #{company_type}, "
            + "update_time = #{update_time} "
            + "WHERE id = #{id}")
    int updateCompanyById(CompanyEntity companyEntity);

    @Select("select * from company where id =#{id}")
    CompanyEntity selectCompanyById(Integer id);

}
