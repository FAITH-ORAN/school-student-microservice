package com.example.api_gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        String incomingUrl = exchange.getRequest().getURI().toString();
        logger.info("🚀 Incoming request -> Method: {}, URI: {}", exchange.getRequest().getMethod(), incomingUrl);

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            URI outgoingUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);

            if (outgoingUri != null) {
                logger.info("🔀 Routed to -> URI: {}", outgoingUri.toString());
            } else {
                logger.warn("⚠️ No outgoing URL found, routing might have failed!");
            }
        }));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

