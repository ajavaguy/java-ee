package com.bookshop.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.shopbook.BookItem;
import com.shopbook.ItemManager;
import com.shopbook.ShopBookLocal;

@Named
@ConversationScoped
public class BookItemDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	private long itemId;
	
	private BookItem item;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private ShopBookLocal bookLocal;
	
	private ItemManager itemManager = new ItemManager();
	
	public void fetchItem() {
		this.item = this.bookLocal.findItemBy(itemId);
	}
	
	public void addManager() {
		this.itemManager.getBookItems().add(item);
		this.item.getItemManagers().add(this.itemManager);
		
		this.bookLocal.saveItem(item);
		this.item = this.bookLocal.findItemBy(itemId);
	}
	
	@PostConstruct
	public void init() {
		this.conversation.begin();
	}
	
	@PreDestroy
	public void destroy() {
		this.conversation.end();
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

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public ShopBookLocal getBookLocal() {
		return bookLocal;
	}

	public void setBookLocal(ShopBookLocal bookLocal) {
		this.bookLocal = bookLocal;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}
