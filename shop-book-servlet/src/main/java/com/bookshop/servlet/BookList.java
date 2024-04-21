package com.bookshop.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookList {

	private static Map<String, BookItem> bookItems = new HashMap<>();

	public static void addItem(BookItem bookItem) {
		bookItems.put(bookItem.getName(), bookItem);
	}

	public static BookItem getItem(String sku) {
		return bookItems.get("sku");
	}

	public static List<BookItem> getItems() {
		return new ArrayList<BookItem>(bookItems.values());
	}

}
