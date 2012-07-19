package com.basicapps.redditpics.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.basicapps.redditpics.R;
import com.basicapps.redditpics.model.Post;

public class PostAdapter extends FillableBaseAdapter<Post> {
	
	public PostAdapter(Context context, List<Post> items) {
		super(context, items);
	}
	
	private class PostViewHolder {
		private TextView postTitle;
		private ImageView postImage;
		
		public PostViewHolder(View view) {
			postTitle = (TextView)view.findViewById(R.id.postTitle_textView);
			postImage = (ImageView)view.findViewById(R.id.postImage_imageView);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View newView = null; 
		PostViewHolder postViewHolder= null;
		
		if(convertView == null) {
			newView = ((LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.image_list_item_layout, null);
			postViewHolder = new PostViewHolder(newView);
		} else {
			newView = convertView;
			postViewHolder = (PostViewHolder)convertView.getTag();
		}
		
		Post currentPost = mItems.get(position);
		
		postViewHolder.postTitle.setText(currentPost.getPostData().getTitle());
		Log.d("TAG", "Position:" + position + " - " + currentPost.getPostData().getTitle() +": " + currentPost.getPostData().getImageUrl());
		AQuery aq = new AQuery(postViewHolder.postImage);
		
		if( aq.shouldDelay(position, convertView, parent, currentPost.getPostData().getImageUrl())) {
			aq.image(aq.getCachedImage(R.drawable.ic_launcher), 1.0f / 1.0f);
		} else {
			aq.image(currentPost.getPostData().getImageUrl(), false, true, 500, 0, aq.getCachedImage(currentPost.getPostData().getThumbnailUrl()), AQuery.FADE_IN, 1.0f / 1.0f);
		}
		
		//aq.progress(R.id.postImage_progressBar);
		//aq.image(currentPost.getPostData().getImageUrl(), false, true, 500, 0, aq.getCachedImage(currentPost.getPostData().getThumbnailUrl()), AQuery.FADE_IN, 1.0f / 1.0f);
		
		newView.setTag(postViewHolder);
		
		return newView;
	}

}
