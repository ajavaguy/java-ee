package com.shopbook;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ShopBookLocal {
	public List<BookItem> getItems();
	
	public void addItem(BookItem item);
	
	public BookItem findItemBy(long itemId);
	
	public void deleteItemBy(BookItem bookItem);
	
	public List<BookItem> searchByName(String name);
	
	public void saveItem(BookItem bookItem);
}
