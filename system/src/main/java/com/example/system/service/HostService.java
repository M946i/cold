package com.example.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.system.entity.HostEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface HostService extends IService<HostEntity> {
    List<HostEntity> getAllHost();
    int insert(String company_number, String warehouse_number, String host_name, String host_number);
}
