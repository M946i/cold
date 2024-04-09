package com.example.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.system.entity.CompanyEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface CompanyService extends IService<CompanyEntity> {
    List<CompanyEntity> getAllCompany();
    int insert(String company_name, String company_number, String company_manager_name, String company_manager_phone, String company_address , String company_type);

}
