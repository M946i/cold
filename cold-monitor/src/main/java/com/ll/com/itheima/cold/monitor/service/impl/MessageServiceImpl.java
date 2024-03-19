package com.ll.com.ll.cold.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.cold.common.admin.dao.MessageDao;
import com.ll.cold.common.netty.entity.MessageEntity;
import com.ll.com.ll.cold.monitor.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageEntity> implements MessageService {

    @Override
    public IPage queryMessageRealtime(Map<String, Object> parames) {
        //组装查询条件
        QueryWrapper queryWrapper = getMessageCondition(parames);
        //查询
        int page = Integer.valueOf(parames.get("page").toString());
        int size = Integer.valueOf(parames.get("pagesize").toString());
        return this.page(new Page<MessageEntity>(page, size),
                queryWrapper);
    }

    private QueryWrapper getMessageCondition(Map<String, Object> params) {
        QueryWrapper<MessageEntity> queryWrapper = new QueryWrapper<>();

        String companyid = params.get("companyId") == null ? null : params.get("companyId").toString().trim();
        if (companyid != null) {
            queryWrapper.eq("companyId", companyid);
        }
        //添加其他参数
        //...
        return queryWrapper;
    }
}
