package com.ll.cold.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.cold.common.admin.entity.HostEntity;
import com.ll.cold.common.utils.PageUtils;

import java.util.Map;

/**
 * 主机管理
 */
public interface HostService extends IService<HostEntity> {
    PageUtils queryPage(Map<String, Object> params);
}

