package com.bookshop.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

//@Named("remoteInventoryService")
//@RemoteService
//@Alternative
public class RemoteInventoryService implements InventoryService, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Long, InventoryItem> items = new HashMap<>();
	
	@Override
	@Logging
	public void createItem(Long bookItemId, String name) {
		System.out.println("Remote Inventory Service");
		long inventoryId = items.size() + 1;
		this.items.put(bookItemId, new InventoryItem(inventoryId, bookItemId, name, 0L));
	}
	
	@Override
	public Long getQuatity(Long bookItemId) {
		return 0L;
	}

}
