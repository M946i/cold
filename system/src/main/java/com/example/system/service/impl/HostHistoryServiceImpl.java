package com.example.system.service.impl;

import com.example.system.dao.HostHistoryDao;
import com.example.system.entity.HostHistoryEntity;
import com.example.system.service.HostHistoryService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostHistoryServiceImpl extends ServiceImpl<HostHistoryDao, HostHistoryEntity> implements HostHistoryService {
    @Autowired
    HostHistoryDao hostHistoryDao;

    @Override
    public List<HostHistoryEntity> selectLastDayHostHistory() {
        return hostHistoryDao.selectLastDayHostHistory();
    }

    @Override
    public String[] getHead() {
        return hostHistoryDao.getHead();
    }

    @Override
    public List<HostHistoryEntity> getValues() {
        return hostHistoryDao.getValues();
    }

    @Override
    public String getName() {
        return "host_history";
    }

    @Override
    public int addHostHistory(HostHistoryEntity hostHistoryEntity) {
        return hostHistoryDao.addHostHistory(hostHistoryEntity);
    }
}
