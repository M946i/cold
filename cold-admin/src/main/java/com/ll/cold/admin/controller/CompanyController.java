package com.ll.cold.admin.controller;

import com.ll.cold.admin.service.CompanyService;
import com.ll.cold.common.admin.entity.CompanyEntity;
import com.ll.cold.common.utils.PageUtils;
import com.ll.cold.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * 企业信息表
 *
 * @author Administrator
 */
@RestController
@RequestMapping("admin/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = companyService.queryPage(params);
        return Result.ok(page.getPageMap());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {
        CompanyEntity company = companyService.getById(id);
        return Result.ok().put("company", company);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody CompanyEntity company) {
        String uuid = UUID.randomUUID().toString();
        company.setId(uuid);

        companyService.save(company);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody CompanyEntity company) {
        companyService.updateById(company);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(String id) {
        companyService.removeById(id);

        return Result.ok();
    }

}
