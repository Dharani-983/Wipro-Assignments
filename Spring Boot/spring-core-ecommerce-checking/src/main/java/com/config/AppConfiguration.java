package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.CartValidator;
import com.service.InventoryService;
import com.service.OrderService;
import com.serviceImpl.CartValidatorImpl;
import com.serviceImpl.InventoryServiceImpl;
import com.serviceImpl.OrderServiceImpl;

@Configuration
public class AppConfiguration {
	@Bean
    public InventoryService inventoryService() {
        return new InventoryServiceImpl();
    }

    @Bean
    public CartValidator cartValidator() {
        return new CartValidatorImpl();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(inventoryService(), cartValidator());
    }
}
