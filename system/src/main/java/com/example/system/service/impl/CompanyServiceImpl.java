package com.example.system.service.impl;

import com.example.system.dao.CompanyDao;
import com.example.system.entity.CompanyEntity;
import com.example.system.service.CompanyService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertCompany(String company_name, String company_number, String company_manager_name, String company_manager_phone, String company_address, String company_type) {
        return companyDao.insertCompany(company_name, company_number, company_manager_name, company_manager_phone, company_address, company_type);
    }

    @Override
    public CompanyEntity getCompanyById(Integer id) {
        return companyDao.selectCompanyById(id);
    }

    @Override
    public int updateCompanyById(CompanyEntity companyEntity) {
        return companyDao.updateCompanyById(companyEntity);
    }

    @Override
    public int deleteCompanyByCompany_number(String company_number) {
        return companyDao.deleteCompanyByCompany_number(company_number);
    }
}
