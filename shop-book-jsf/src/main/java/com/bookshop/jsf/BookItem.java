package com.bookshop.jsf;

import java.time.LocalDate;

public class BookItem {
	private long itemId;
	private String name;
	private String manufacturer;
	private String description;
	private LocalDate availableDate;
	
	public BookItem() {}

	public BookItem(long itemId, String name, String manufacturer, String description, LocalDate availableDate) {
		this.itemId = itemId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
	
}
