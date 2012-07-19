package com.basicapps.redditpics.adapter;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class FillableBaseAdapter<T extends ItemId> extends BaseAdapter {

	protected Context mContext;
	protected List<T> mItems;
	
	protected FillableBaseAdapter(Context context, List<T> items) {
		mContext = context;
		mItems = items;
	}
	
	public void fill(List<T> moreItems) {
		mItems.addAll(moreItems);
		notifyDataSetChanged();
	}
	
	public void clear() {
		mItems.clear();
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		if (mItems != null) {
			return mItems.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		if (mItems != null) {
			return mItems.get(position);
		} else {
			return null;
		}
	}

	@Override
	public long getItemId(int position) {
		if (mItems != null) {
			return mItems.get(position).getItemId();
		} else {
			return -1L;
		}
	}

}
