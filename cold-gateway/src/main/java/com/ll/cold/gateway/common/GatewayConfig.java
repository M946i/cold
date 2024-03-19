package com.ll.cold.gateway.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
