package com.ll.com.ll.cold.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.cold.common.netty.entity.MessageEntity;

import java.util.Map;

public interface MessageService extends IService<MessageEntity> {
    IPage queryMessageRealtime(Map<String, Object> parames);
}
