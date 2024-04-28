package com.shopbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_ITEM")
public class BookItem {
	@Id
	@Column(name="BOOK_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AVAILABLE_DATE")
	private LocalDate availableDate;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name = "BOOK_ITEM_ID"), 
					inverseJoinColumns = @JoinColumn(name = "ITEM_MANAGER_ID"))
	private List<ItemManager> itemManagers = new ArrayList<>();
	
	public BookItem() {}

	public BookItem(String name, String manufacturer, String description, LocalDate availableDate) {
		super();
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

	public List<ItemManager> getItemManagers() {
		return itemManagers;
	}

	public void setItemManagers(List<ItemManager> itemManagers) {
		this.itemManagers = itemManagers;
	}
	
}
