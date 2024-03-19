package com.ll.cold.jobs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.cold.common.job.entity.ScheduleJobLogEntity;
import com.ll.cold.common.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
