package com.example.api_gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JWTAuthenticationFilter implements GlobalFilter, Ordered {

    private final JWTUtil jwtUtil;

    public JWTAuthenticationFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        System.out.println("Intercepted request: " + request.getURI());

        if (request.getURI().getPath().startsWith("/auth/")) {
            return chain.filter(exchange);
        }

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            System.out.println("❌ Missing Authorization Header");
            return this.onError(exchange, "Missing Authorization Header", HttpStatus.UNAUTHORIZED);
        }

        // Extract Token
        String authorizationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        System.out.println("🔍 Authorization Header reçu : " + authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            authorizationHeader = authorizationHeader.substring(7);
        } else {
            System.out.println("❌ Invalid Authorization Header format");
            return this.onError(exchange, "Invalid Authorization Header format", HttpStatus.UNAUTHORIZED);
        }

        // Verify Token
        if (!jwtUtil.validateToken(authorizationHeader)) {
            System.out.println("❌ Token invalide");
            return this.onError(exchange, "Invalid Token", HttpStatus.UNAUTHORIZED);
        }

        String username = jwtUtil.extractUsername(authorizationHeader);
        System.out.println("✅ Token validated: user : " + username);

        ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                .header("X-Authenticated-User", username)
                .build();

        return chain.filter(exchange.mutate().request(modifiedRequest).build());
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus status) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        System.out.println("ERROR : " + err);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
