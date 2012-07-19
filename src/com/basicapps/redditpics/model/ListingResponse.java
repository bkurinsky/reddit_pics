package com.basicapps.redditpics.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListingResponse {
	
	@JsonProperty("kind")
	private String mResponseKind;
	
	@JsonProperty("data")
	private ListingData mRootData;
	
	public List<Post> getPosts() {
		return this.mRootData.mPosts;
	}
	
	public static class ListingData {
		
		@JsonProperty("modhash")
		private String mModhash;
		
		@JsonProperty("children")
		private List<Post> mPosts;
		
		@JsonProperty("after")
		private String mAfter;
		
		@JsonProperty("before")
		private String mBefore;
		
	}

}
