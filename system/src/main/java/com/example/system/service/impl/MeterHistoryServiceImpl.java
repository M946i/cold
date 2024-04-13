package com.example.system.service.impl;

import com.example.system.dao.MeterHistoryDao;
import com.example.system.entity.MeterHistoryEntity;
import com.example.system.service.MeterHistoryService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterHistoryServiceImpl extends ServiceImpl<MeterHistoryDao, MeterHistoryEntity> implements MeterHistoryService {
    @Autowired
    MeterHistoryDao meterHistoryDao;

    @Override
    public List<MeterHistoryEntity> selectLastDayMeterHistory() {
        return meterHistoryDao.selectLastDayMeterHistory();
    }

    @Override
    public String[] getHead() {
        return meterHistoryDao.getHead();
    }

    @Override
    public List<MeterHistoryEntity> getValues() {
        return meterHistoryDao.getValues();
    }

    @Override
    public String getName() {
        return "meter_history";
    }

    @Override
    public int addMeterHistory(MeterHistoryEntity meterHistoryEntity) {
        return meterHistoryDao.addMeterHistory(meterHistoryEntity);
    }


}
