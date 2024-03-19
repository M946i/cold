package com.ll.cold.user.controller;

import com.ll.cold.common.user.entity.SysLoginForm;
import com.ll.cold.common.user.entity.SysUserEntity;
import com.ll.cold.common.utils.Result;
import com.ll.cold.user.service.SysUserService;
import com.ll.cold.user.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录相关
 */
@RestController
@RequestMapping("sys/user")
public class SysLoginController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form) {
        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return Result.error("账号或密码不正确");
        }
        //生成token，并保存到数据库
        Result r = sysUserTokenService.createToken(user.getUserId());
        return r;
    }


    /**
     * 退出
     */
    @PostMapping("/logout")
    public Result logout(@RequestHeader(value = "token") String token) {
        sysUserTokenService.logout(token);
        return Result.ok();
    }

    /**
     * 用户信息
     */
    @GetMapping("/info")
    public Result userInfo() {
        SysUserEntity user = sysUserService.queryByUserName("admin");
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getUsername());
        map.put("company", "admin");
        map.put("phone", "");
        map.put("avatar", "");
        map.put("username", user.getUsername());
        map.put("logintime", "");
        return Result.ok(map);
    }
}
