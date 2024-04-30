package com.example.user.controller;

import com.example.user.entity.UserEntity;
import com.example.user.entity.UserHistoryEntity;
import com.example.user.entity.UserTokenEntity;
import com.example.user.service.UserHistoryService;
import com.example.user.service.UserService;
import com.example.user.service.UserTokenService;
import com.example.user.utils.TokenGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {
    private static final int EXPIRE = 12 * 3600;
    @Autowired
    private UserService userService;
    @Autowired
    private UserHistoryService userHistoryService;
    @Autowired
    private UserTokenService userTokenService;


    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserEntity form, HttpServletRequest exchange) throws ParseException {
        HashMap<String, Object> result = new HashMap<>();

        UserEntity userEntity = userService.selectByUserName(form.getUsername());

        if (userEntity != null && (userEntity.getPassword()).equals(new Sha256Hash(form.getPassword()).toString())) {
            // 获取客户端 IP 地址
            String ipAddress = Objects.requireNonNull(exchange.getLocalAddr());
            // 记录用户登录历史

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp loginTime = new Timestamp(simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime());

            userHistoryService.insertUserHistory(form.getUsername(), loginTime, ipAddress);

            //生成一个token
            String token = TokenGenerator.generateValue();

            //当前时间
            Date now = new Date();
            //过期时间
            Date expire_time = new Date(now.getTime() + EXPIRE * 1000);

            int i = userTokenService.reloadUserToken(token, simpleDateFormat.format(expire_time), simpleDateFormat.format(now), userEntity.getUsername());
            UserTokenEntity userToken = userTokenService.getUserTokenByUserName(form.getUsername());
            if (i == 1) {
                result.put("status", "ok");
                result.put("token",userToken.getToken());
            }
        }
        return result;
    }

    @PostMapping("/logout")
    public Map<String, Object> logout(@RequestHeader(value = "token") String token) {
        System.out.println(token);
        userTokenService.setUserTokenExpireTimeByToken(token, LocalDateTime.now().toString());
        Map<String, Object> result = new HashMap<>();
        result.put("status", "ok");
        return result;
    }

    @GetMapping("/userinfo")
    public Map<String, String> userinfo() {
        UserHistoryEntity history = userHistoryService.selectBeforeLogin();
        HashMap<String, String> result = new HashMap<>();
        if (history != null) {
            result.put("上次登录时间", String.valueOf(history.getLogin_time()));
            result.put("上次登录ip", history.getIp());
        }
        return result;
    }

    @PostMapping("/checkToken")
    public Map<String, String> checkToken(@Param("token") String token) {
        UserTokenEntity userToken = userTokenService.getUserTokenExpireTimeByToken(token);
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "false");
        if (userToken != null) {
            Date nowDate = new Date();
            Date parse = userToken.getExpire_time();
            if (nowDate.after(parse)) {
                return result;
            }
            result.replace("status", "true");
        }
        return result;
    }
}
