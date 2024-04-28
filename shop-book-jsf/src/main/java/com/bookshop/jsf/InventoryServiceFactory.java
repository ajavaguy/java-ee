package com.bookshop.jsf;

import java.time.LocalDateTime;

import javax.enterprise.inject.Produces;

public class InventoryServiceFactory {

	//@Produces
	public InventoryService inventoryService() {
		return LocalDateTime.now().getHour() > 12 
				? new LocalInventoryService()
				: new RemoteInventoryService();
	}
}
