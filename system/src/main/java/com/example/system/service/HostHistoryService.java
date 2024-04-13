package com.example.system.service;

import com.example.system.entity.HostHistoryEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HostHistoryService extends IService<HostHistoryEntity> {
    List<HostHistoryEntity> selectLastDayHostHistory();
    String[] getHead();
    List<HostHistoryEntity> getValues();
    String getName();
    int addHostHistory(HostHistoryEntity hostHistoryEntity);
}
