package com.bookshop.jsf;

import java.util.HashMap;
import java.util.Map;

public class LocalInventoryService implements InventoryService {

	private Map<Long, InventoryItem> items = new HashMap<>();
	
	@Override
	public void createItem(Long bookItemId, String name) {
		long inventoryId = items.size() + 1;
		this.items.put(bookItemId, new InventoryItem(inventoryId, bookItemId, name, 0L));
	}

	@Override
	public Long getQuatity(Long bookItemId) {
		return 0L;
	}

}
