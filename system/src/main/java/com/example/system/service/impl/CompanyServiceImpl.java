package com.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.system.dao.CompanyDao;
import com.example.system.entity.CompanyEntity;
import com.example.system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {
    @Autowired
    CompanyDao companyDao;

    @Override
    public List<CompanyEntity> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public int insert(String company_name, String company_number, String company_manager_name, String company_manager_phone, String company_address, String company_type) {
        return companyDao.insert(company_name,company_number,company_manager_name,company_manager_phone,company_address,company_type);
    }
}
