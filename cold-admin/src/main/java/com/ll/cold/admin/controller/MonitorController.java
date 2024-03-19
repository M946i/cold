package com.ll.cold.admin.controller;

import com.ll.cold.admin.service.MonitorService;
import com.ll.cold.common.admin.entity.MonitorEntity;
import com.ll.cold.common.utils.PageUtils;
import com.ll.cold.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;


/**
 * 监控设置
 */
@RestController
@RequestMapping("admin/monitor/config")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = monitorService.queryPage(params);

        return Result.ok(page.getPageMap());
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody MonitorEntity monitor) {
        String uuid = UUID.randomUUID().toString();
        monitor.setId(uuid);
        monitorService.save(monitor);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody MonitorEntity monitor) {
        monitorService.updateById(monitor);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(String id) {
        monitorService.removeById(id);
        return Result.ok();
    }

}
