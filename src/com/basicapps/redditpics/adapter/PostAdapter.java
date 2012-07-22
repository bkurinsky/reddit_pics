package com.basicapps.redditpics.adapter;

import java.util.Date;
import java.util.List;

import org.ocpsoft.pretty.time.PrettyTime;

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
import com.basicapps.redditpics.util.TypefaceHelper;
import com.basicapps.redditpics.util.TypefaceHelper.TypefaceName;

public class PostAdapter extends FillableBaseAdapter<Post> {
	
	public PostAdapter(Context context, List<Post> items) {
		super(context, items);
	}
	
	private class PostViewHolder {
		private TextView postTitle;
		private ImageView postImage;
		private TextView postUpvotes;
		private TextView postDownvotes;
		private TextView postTimestamp;
		private TextView postUser;
		
		// ID's to style with fonts
		public final int[] resourceIds = {
			R.id.postListItem_postTitleTextView,
			R.id.postListItem_postVoteStartCharacterTextView,
			R.id.postListItem_postUpvotesTextView,
			R.id.postListItem_postVoteDividerTextView,
			R.id.postListItem_postDownvotesTextView,
			R.id.postListItem_postVoteEndCharacterTextView,
			R.id.postListItem_postSubmittedTextView,
			R.id.postListItem_postTimestampTextView,
			R.id.postListItem_postSubmittedByTextView,
			R.id.postListItem_postUserTextView
		};
		
		public PostViewHolder(View view) {
			postTitle = (TextView)view.findViewById(R.id.postListItem_postTitleTextView);
			postImage = (ImageView)view.findViewById(R.id.postListItem_postImageImageView);
			postUpvotes = (TextView)view.findViewById(R.id.postListItem_postUpvotesTextView);
			postDownvotes = (TextView)view.findViewById(R.id.postListItem_postDownvotesTextView);
			postTimestamp = (TextView)view.findViewById(R.id.postListItem_postTimestampTextView);
			postUser = (TextView)view.findViewById(R.id.postListItem_postUserTextView);
			TypefaceHelper.applyTypeFaceToViewIds(view.getContext(), view, TypefaceName.VERDANA, resourceIds);
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
		postViewHolder.postUpvotes.setText(currentPost.getPostData().getUpvotes().toString());
		postViewHolder.postDownvotes.setText(currentPost.getPostData().getDownvotes().toString());
		postViewHolder.postTimestamp.setText( new PrettyTime().format( new Date(currentPost.getPostData().getTimestamp()) ));
		postViewHolder.postUser.setText(currentPost.getPostData().getAuthorName());
		
		Log.d("TAG", "Position:" + position + " - " + currentPost.getPostData().getTitle() +": " + currentPost.getPostData().getImageUrl());
		AQuery aq = new AQuery(postViewHolder.postImage);
		
		if( aq.shouldDelay(position, convertView, parent, currentPost.getPostData().getImageUrl())) {
			aq.image(aq.getCachedImage(R.drawable.ic_launcher), 1.0f / 1.0f);
		} else {
			aq.image(currentPost.getPostData().getImageUrl(), false, true, 500, 0, aq.getCachedImage(currentPost.getPostData().getThumbnailUrl()), AQuery.FADE_IN, 1.0f / 1.0f);
		}
		
		newView.setTag(postViewHolder);
		
		return newView;
	}

}
