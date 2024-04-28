package com.bookshop.jsf;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.shopbook.BookItem;
import com.shopbook.ShopBookLocal;

@Named
@ConversationScoped
public class BookItemDeleteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private long itemId;
	
	private BookItem item;

	@Inject
	private BookItemFormBean bookItemFormBean;
	
	@Inject
	private ShopBookLocal bookLocal;
	
	@Inject
	private Conversation conversation;
	
	public void fetchItem() {
//		this.item = this.bookItemFormBean.getItems()
//				.stream()
//				.filter(item -> item.getItemId() == itemId)
//				.findFirst()
//				.orElse(null);
		conversation.begin();
		this.item = this.bookLocal.findItemBy(itemId);
	}
	
	public String removeItem() {
		//this.bookItemFormBean.getItems().removeIf(item -> item.getItemId() == itemId);
		this.bookLocal.deleteItemBy(item);
		conversation.end();
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
