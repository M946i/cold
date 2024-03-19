package com.ll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DruidApp {
    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class, args);
    }
}
