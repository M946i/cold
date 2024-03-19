package com.ll.cold.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.cold.admin.service.MeterService;
import com.ll.cold.common.admin.dao.MeterDao;
import com.ll.cold.common.admin.entity.MeterEntity;
import com.ll.cold.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 仪表管理
 */
@Service("meterService")
public class MeterServiceImpl extends ServiceImpl<MeterDao, MeterEntity> implements MeterService {
    /**
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int current = params.get("page") == null ? 1 : Integer.valueOf(params.get("page").toString());
        int size = params.get("pagesize") == null ? 10 : Integer.valueOf(params.get("pagesize").toString());
        Page<MeterEntity> page = new Page<>(current, size);
        String housename = params.get("housename") == null ? "" : params.get("housename").toString();
        QueryWrapper<MeterEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(MeterEntity::getHousename, housename)
                .orderByAsc(MeterEntity::getMetername);
        IPage<MeterEntity> result = this.page(page, wrapper);
        return new PageUtils(result);
    }
}