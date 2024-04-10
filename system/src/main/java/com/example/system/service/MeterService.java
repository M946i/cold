package com.example.system.service;


import com.example.system.entity.MeterEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeterService extends IService<MeterEntity> {
    List<MeterEntity> getAllMeter();
    int insertMeter(String company_number, String warehouse_number, String host_number, String meter_number, Double min_temperature, Double max_temperature, Double min_humidity, Double max_humidity);

}
