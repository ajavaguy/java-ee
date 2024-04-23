package com.bookshop.jsf;

import java.io.Serializable;

public interface InventoryService extends Serializable {
	public void createItem(Long bookItemId, String name);
	
	public Long getQuatity(Long bookItemId);
}
