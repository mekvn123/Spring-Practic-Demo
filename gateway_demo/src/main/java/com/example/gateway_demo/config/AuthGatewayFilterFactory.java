package com.example.gateway_demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    private static final String NAME = "name";
    private static final String NUM = "num";

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME, NUM);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("This is GateWay's AuthFilter.");
            String token = exchange.getRequest().getHeaders().getFirst("Token");
            if (Objects.nonNull(token)) {
                String str = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
                log.info("gateway token is :{}", str);
                return chain.filter(exchange);
            }
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        };
    }

    @Setter
    @Getter
    public static class Config {
        private String name;
        private int num;
    }
}
