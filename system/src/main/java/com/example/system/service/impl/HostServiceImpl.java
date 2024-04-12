package com.example.system.service.impl;

import com.example.system.dao.HostDao;
import com.example.system.entity.HostEntity;
import com.example.system.service.HostService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertHost(String company_number, String warehouse_number, String host_name, String host_number) {
        return hostDao.insertHost(company_number, warehouse_number, host_name, host_number);
    }

    @Override
    public HostEntity getHostById(Integer id) {
        return hostDao.selectHostById(id);
    }

    @Override
    public int updateHostById(HostEntity hostEntity) {
        return hostDao.updateHostById(hostEntity);
    }

    @Override
    public int deleteHostByHost_number(String host_number) {
        return hostDao.deleteHostByHost_number(host_number);
    }
}
