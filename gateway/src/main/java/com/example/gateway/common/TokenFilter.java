package com.example.gateway.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

/**
 * API鉴权
 */
public class TokenFilter implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!exchange.getRequest().getPath().value().equals("/user/login")) {
            String token = exchange.getRequest().getHeaders().getFirst("token");
            if (token == null || token.isEmpty()) {
                logger.info("token为空...");
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            //Post http://127.0.0.1:8088/checkToken?token=token
            String requestUrl = "http://localhost:8088/user/checkToken?token="+token;
            // 发送post请求

            try {

                Map<String, String> responseMap = HttpUtils.mapStringToMap(HttpUtils.sendPostWithJson(requestUrl));
                if (!"\"true\"".equals(responseMap.values().iterator().next())) {

                    logger.info("token无效");
                    return exchange.getResponse().setComplete();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
