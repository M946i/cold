package com.ll.cold.common.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ll.cold.common.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 *
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
