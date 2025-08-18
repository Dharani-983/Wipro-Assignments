package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("citizen-service", r -> r.path("/api/citizens/**")
                        .uri("http://localhost:1116"))
                .route("department-service", r -> r.path("/api/departments/**")
                        .uri("http://localhost:1117"))
                .route("employee-service", r -> r.path("/api/employees/**")
                        .uri("http://localhost:1118"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://localhost:1119"))
                .build();
    }
}
