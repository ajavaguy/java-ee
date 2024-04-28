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

	@Override
	public BookItem findItemBy(long itemId) {
		return this.entityManager.find(BookItem.class, itemId);
	}

	@Override
	public void deleteItemBy(BookItem bookItem) {
		BookItem removeItem = this.entityManager.contains(bookItem) ? bookItem : this.entityManager.merge(bookItem);
		this.entityManager.remove(removeItem);
	}

	@Override
	public List<BookItem> searchByName(String name) {
		return this.entityManager.createQuery("select c from BookItem c where c.name like :name", BookItem.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public void saveItem(BookItem bookItem) {
		this.entityManager.merge(bookItem);
	}

}
