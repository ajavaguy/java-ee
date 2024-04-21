package com.bookshop.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class BookItemFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private BookItem item = new BookItem();
	private List<BookItem> items = new ArrayList<>();
	
	public String addItem() {
		long itemId = this.items.size() + 1;
		this.items.add(new BookItem(itemId, item.getName(), item.getManufacturer(), item.getDescription(), item.getAvailableDate()));
		return "list?faces-redirect=true";
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
	
}
