package com.ll.cold.common.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ll.cold.common.netty.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
}
