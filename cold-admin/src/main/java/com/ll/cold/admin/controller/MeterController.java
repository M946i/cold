package com.ll.cold.admin.controller;

import com.ll.cold.admin.service.MeterService;
import com.ll.cold.common.admin.entity.MeterEntity;
import com.ll.cold.common.utils.JedisUtil;
import com.ll.cold.common.utils.PageUtils;
import com.ll.cold.common.utils.Result;
import com.ll.cold.common.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * 仪表管理
 */
@RestController
@RequestMapping("admin/meter")
public class MeterController {
    @Autowired
    private MeterService meterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = meterService.queryPage(params);

        return Result.ok(page.getPageMap());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {
        MeterEntity meter = meterService.getById(id);

        return Result.ok().put("meter", meter);
    }

    /**
     * 保存仪表
     */
    @RequestMapping("/save")
    public Result save(@RequestBody MeterEntity meter) throws Exception {
        String uuid = UUID.randomUUID().toString();
        meter.setId(uuid);
        meterService.save(meter);

        JedisUtil.Strings strings = JedisUtil.getInstance().new Strings();
        strings.set(meter.getMetercode(), SerializeUtil.serialize(meter));

        return Result.ok();
    }

    /**
     * 修改仪表
     */
    @RequestMapping("/update")
    public Result update(@RequestBody MeterEntity meter) {
        meterService.updateById(meter);

        JedisUtil.getInstance().getJedis().del(meter.getMetercode());

        JedisUtil.Strings strings = JedisUtil.getInstance().new Strings();
        strings.set(meter.getMetercode(), SerializeUtil.serialize(meter));

        return Result.ok();
    }

    /**
     * 删除仪表
     */
    @RequestMapping("/delete")
    public Result delete(String id) {
        meterService.removeById(id);

        JedisUtil.getInstance().getJedis().del(meterService.getById(id).getMetercode());

        return Result.ok();
    }
}
