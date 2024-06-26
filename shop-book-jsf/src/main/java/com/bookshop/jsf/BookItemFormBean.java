package com.bookshop.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.shopbook.BookItem;
import com.shopbook.ShopBookLocal;

@RequestScoped
@Named
public class BookItemFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private BookItem item = new BookItem();
	private List<BookItem> items = new ArrayList<>();
	
	@Inject
	private ShopBookLocal bookLocal;
	
	@Inject
	@Named("localInventoryService")
	//@RemoteService
	private InventoryService inventoryService;
	
//	public String addItem() {
//		long itemId = this.items.size() + 1;
//		this.items.add(new BookItem(itemId, item.getName(), item.getManufacturer(), item.getDescription(), item.getAvailableDate()));
//		return "list?faces-redirect=true";
//	}
	
	private String searchText;
	
	public void searchByName() {
		this.items = this.bookLocal.searchByName(searchText);
	}
	
	@Logging
	public String addItem() {
		//long itemId = this.bookLocal.getItems().size() + 1;
		this.bookLocal.addItem(new BookItem(item.getName(), item.getManufacturer(), item.getDescription(), item.getAvailableDate()));
		this.inventoryService.createItem(item.getItemId(), item.getName());
		return "list?faces-redirect=true";
	}
	
	public void init() {
		this.items = this.bookLocal.getItems();
	}
	
	public BookItem getItem() {
		return item;
	}
	
	public void setItem(BookItem item) {
		this.item = item;
	}
	
	public List<BookItem> getItems() {
		return items;
	}
	
	public void setItems(List<BookItem> items) {
		this.items = items;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
}
