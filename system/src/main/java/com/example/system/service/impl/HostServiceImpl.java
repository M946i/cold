package com.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.system.dao.HostDao;
import com.example.system.entity.HostEntity;
import com.example.system.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HostServiceImpl extends ServiceImpl<HostDao, HostEntity> implements HostService {
    @Autowired
    HostDao hostDao;

    @Override
    public List<HostEntity> getAllHost() {
        return hostDao.getAllHost();
    }

    @Override
    public int insert(String company_number, String warehouse_number, String host_name, String host_number) {
        return hostDao.insert(company_number, warehouse_number, host_name, host_number);
    }
}
