package com.serviceImpl;

import java.util.Arrays;
import java.util.List;

import com.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	private final List<String> availableItems = Arrays.asList("item1", "item2", "item3");

	@Override
	public boolean isAvailable(String itemId) {
		// TODO Auto-generated method stub
		return availableItems.contains(itemId);
	}

}
