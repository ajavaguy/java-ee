package com.shopbook;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

//@Stateless
@Singleton
@LocalBean
public class ShopBook implements ShopBookLocal {
	private List<BookItem> items = new ArrayList<BookItem>();
	
    public ShopBook() {}

	@Override
	public List<BookItem> getItems() {
		return this.items;
	}

	@Override
	public void addItem(BookItem item) {
		this.addItem(item);
	}

}
