package com.ll.cold.common.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ll.cold.common.admin.entity.WarehouseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库表
 *
 */
@Mapper
public interface WarehouseDao extends BaseMapper<WarehouseEntity> {
	
}
