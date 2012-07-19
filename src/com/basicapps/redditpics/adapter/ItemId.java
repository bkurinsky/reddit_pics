package com.basicapps.redditpics.adapter;

import java.util.Random;

public class ItemId {
	
	private long mItemId;
	
	public ItemId(long itemId) {
		mItemId = itemId;
	}
	
	public ItemId() {
		mItemId = (new Random()).nextLong();
	}
	
	public long getItemId() {
		return mItemId;
	}

}
