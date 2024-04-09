package com.example.system.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MybatisPlusConfiguration implements MetaObjectHandler {

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时自动填充");
        this.setFieldValByName("stock", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时自动填充");
        this.setFieldValByName("stock", -9090, metaObject);
    }
}
