package com.example.system.service;

import com.example.system.entity.MeterHistoryEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeterHistoryService extends IService<MeterHistoryEntity> {
    List<MeterHistoryEntity> selectLastDayMeterHistory();
    String[] getHead();
    List<MeterHistoryEntity> getValues();
    String getName();
    int addMeterHistory(MeterHistoryEntity meterHistoryEntity);
}
