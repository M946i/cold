package com.ll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 分布式任务调度（硬件模拟）
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JobsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }
}
