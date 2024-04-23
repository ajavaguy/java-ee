package com.bookshop.jsf;

public class InventoryItem {
	private long inventoryItemId;
	private long bookItemId;
	private String name;
	private Long quantity;
	
	public InventoryItem(long inventoryItemId, long bookItemId, String name, Long quantity) {
		this.inventoryItemId = inventoryItemId;
		this.bookItemId = bookItemId;
		this.name = name;
		this.quantity = quantity;
	}

	public long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public long getBookItemId() {
		return bookItemId;
	}

	public void setBookItemId(long bookItemId) {
		this.bookItemId = bookItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
