package com.basicapps.redditpics.model;

import android.text.Html;
import android.text.Spanned;

import com.basicapps.redditpics.adapter.ItemId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "kind" })
public class Post extends ItemId {

	@JsonProperty("data")
	private PostData mPostData;
	public PostData getPostData() { return mPostData; }

	@JsonIgnoreProperties({ "domain", "banned_by", "media_embed", "subreddit",
			"selftext_html", "selftext", "likes", "link_flair_text", "clicked",
			"score", "approved_by", "hidden", "subreddit_id", "edited",
			"link_flair_css_class", "author_flair_css_class", "saved",
			"is_self", "created", "author_flair_text", "media", "num_reports" })
	public static class PostData {
		@JsonProperty("id")
		String mId;

		@JsonProperty("title")
		String mTitle;
		public Spanned getTitle() { return Html.fromHtml(mTitle); }

		@JsonProperty("num_comments")
		Integer mComments;

		@JsonProperty("over_18")
		Boolean mOverEighteen;

		@JsonProperty("thumbnail")
		String mThumbnailUrl;
		public String getThumbnailUrl() { return mThumbnailUrl; }

		@JsonProperty("downs")
		Integer mDownvotes;

		@JsonProperty("permalink")
		String mPermalinkSuffix;

		@JsonProperty("name")
		String mName;

		@JsonProperty("created_utc")
		Integer mTimestamp;

		@JsonProperty("url")
		String mLinkUrl;
		public String getLinkUrl() { return mLinkUrl; }
		
		public String getImageUrl() {
			if ( mLinkUrl.startsWith("http://imgur.com") ) {
				return mLinkUrl + ".png";
			} else {
				return mLinkUrl;
			}
		}

		@JsonProperty("author")
		String mAuthorName;

		@JsonProperty("ups")
		Integer mUpvotes;
	}
}
