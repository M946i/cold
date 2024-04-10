package com.example.system.service;

import com.example.system.entity.CompanyEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService extends IService<CompanyEntity> {
    List<CompanyEntity> getAllCompany();
    int insertCompany(String company_name, String company_number, String company_manager_name, String company_manager_phone, String company_address , String company_type);

}
