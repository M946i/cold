package com.example.system.service;

import com.example.system.entity.HostHistoryEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HostHistoryService extends IService<HostHistoryEntity> {
    List<HostHistoryEntity> selectLastDayHostHistory();

    int insertHostHistory(HostHistoryEntity hostHistoryEntity);
}
