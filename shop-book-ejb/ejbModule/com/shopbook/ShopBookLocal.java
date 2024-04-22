package com.shopbook;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ShopBookLocal {
	public List<BookItem> getItems();
	public void addItem(BookItem item);
}
