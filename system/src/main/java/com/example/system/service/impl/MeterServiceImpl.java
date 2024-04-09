package com.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.system.dao.MeterDao;
import com.example.system.entity.MeterEntity;
import com.example.system.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeterServiceImpl extends ServiceImpl<MeterDao, MeterEntity> implements MeterService {
    @Autowired
    MeterDao meterDao;

    @Override
    public List<MeterEntity> getAllMeter() {
        return meterDao.getAllMeter();
    }

    @Override
    public int insert(String company_number, String warehouse_number, String host_number, String meter_number, Double min_temperature, Double max_temperature, Double min_humidity, Double max_humidity) {
        return meterDao.insert(company_number, warehouse_number, host_number, meter_number, min_temperature, max_temperature, min_humidity, max_humidity);
    }
}
