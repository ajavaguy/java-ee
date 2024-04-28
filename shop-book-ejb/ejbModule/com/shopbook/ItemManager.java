package com.shopbook;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="ITEM_MANAGER")
public class ItemManager {

	@Id
	@Column(name = "ITEM_MANAGER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemManagerId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Email
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToMany(mappedBy = "itemManagers")
	private List<BookItem> bookItems = new ArrayList<>();

	public ItemManager() {}

	public ItemManager(List<BookItem> bookItems, String firstName, String lastName) {
		super();
		this.bookItems = bookItems;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getItemManagerId() {
		return itemManagerId;
	}

	public void setItemManagerId(Long itemManagerId) {
		this.itemManagerId = itemManagerId;
	}

	public List<BookItem> getBookItems() {
		return bookItems;
	}

	public void setBookItems(List<BookItem> bookItems) {
		this.bookItems = bookItems;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
