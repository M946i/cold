package com.example.system.service;

import com.example.system.entity.HostEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HostService extends IService<HostEntity> {
    List<HostEntity> getAllHost();

    int insertHost(String company_number, String warehouse_number, String host_name, String host_number);

    HostEntity getHostById(Integer id);

    int updateHostById(HostEntity hostEntity);

    int deleteHostByHost_number(String host_number);
}
