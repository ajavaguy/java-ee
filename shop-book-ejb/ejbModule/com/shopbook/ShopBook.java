package com.shopbook;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Stateless
@Singleton
@LocalBean
public class ShopBook implements ShopBookLocal {
	@PersistenceContext
	private EntityManager entityManager;
	
	private List<BookItem> items = new ArrayList<BookItem>();
	
    public ShopBook() {}

	@Override
	public List<BookItem> getItems() {
		List<BookItem> bookItems = this.entityManager.createQuery("select c from BookItem c", BookItem.class)
				.getResultList();
		for (BookItem item : bookItems) {
			System.out.println(item.getName());
		}
		return bookItems;
	}

	@Override
	public void addItem(BookItem item) {
		this.entityManager.persist(item);
	}

}
