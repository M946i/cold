package com.ll.cold.druid.service;

import com.ll.cold.common.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Administrator
 */
public interface DruidService {
    /**
     * 查询Druid数据列表
     */
    Result queryDruidList(@RequestParam Map<String, Object> params);

    /**
     * 查询设备Druid温度湿度（最近10条）
     */
    Result queryDruidTumHum(@RequestParam Map<String, Object> params);
}
