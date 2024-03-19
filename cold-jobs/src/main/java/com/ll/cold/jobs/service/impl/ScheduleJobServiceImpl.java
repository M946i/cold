package com.ll.cold.jobs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.cold.common.job.dao.ScheduleJobDao;
import com.ll.cold.common.job.entity.ScheduleJobEntity;
import com.ll.cold.common.utils.Constant;
import com.ll.cold.common.utils.PageUtils;
import com.ll.cold.jobs.service.ScheduleJobService;
import com.ll.cold.jobs.utils.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobDao, ScheduleJobEntity> implements ScheduleJobService {

    @Autowired
    private Scheduler scheduler;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<ScheduleJobEntity> scheduleJobList = this.list();
        for (ScheduleJobEntity scheduleJob : scheduleJobList) {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            } else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String beanName = (String) params.get("beanName");
        //分页参数
        int current = params.get("page") == null ? 1 : Integer.valueOf(params.get("page").toString());
        int size = params.get("list") == null ? 10 : Integer.valueOf(params.get("list").toString());
        Page<ScheduleJobEntity> page = new Page<>(current, size);
        //查询条件
        QueryWrapper<ScheduleJobEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(ScheduleJobEntity::getBeanName, beanName)
                .orderByDesc(ScheduleJobEntity::getCreateTime);
        //查询数据
        IPage<ScheduleJobEntity> result = this.page(page, wrapper);
        return new PageUtils(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJob(ScheduleJobEntity scheduleJob) {
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
        this.save(scheduleJob);
        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ScheduleJobEntity scheduleJob) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
        this.updateById(scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        }
        //删除数据
        this.removeByIds(Arrays.asList(jobIds));
    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", jobIds);
        map.put("status", status);
        return baseMapper.updateBatch(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.run(scheduler, this.getById(jobId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.pauseJob(scheduler, jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resume(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.resumeJob(scheduler, jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue());
    }
}
