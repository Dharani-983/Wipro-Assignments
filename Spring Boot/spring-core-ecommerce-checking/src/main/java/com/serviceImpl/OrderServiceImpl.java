package com.serviceImpl;

import java.util.Arrays;

import com.model.Order;
import com.service.CartValidator;
import com.service.InventoryService;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private final InventoryService inventoryService;
    private final CartValidator cartValidator;

    public OrderServiceImpl(InventoryService inventoryService, CartValidator cartValidator) {
        this.inventoryService = inventoryService;
        this.cartValidator = cartValidator;
    }

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        Order order = new Order();
        order.setOrderId(cartId);
        order.setItemIds(Arrays.asList("item1", "item2", "item4")); 

        for (String itemId : order.getItemIds()) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }

        return "Checkout successful for " + cartId;
    }

}
