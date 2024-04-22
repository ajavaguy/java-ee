package com.bookshop.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.shopbook.BookItem;

@Named
@RequestScoped
public class BookItemDeleteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private long itemId;
	
	private BookItem item;

	@Inject
	private BookItemFormBean bookItemFormBean;
	
	public void fetchItem() {
		this.item = this.bookItemFormBean.getItems()
				.stream()
				.filter(item -> item.getItemId() == itemId)
				.findFirst()
				.orElse(null);
	}
	
	public String removeItem() {
		this.bookItemFormBean.getItems().removeIf(item -> item.getItemId() == itemId);
		return "list?faces-redirect=true";
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public BookItem getItem() {
		return item;
	}

	public void setItem(BookItem item) {
		this.item = item;
	}
	
}
