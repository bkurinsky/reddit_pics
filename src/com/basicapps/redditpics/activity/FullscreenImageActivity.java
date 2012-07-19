package com.basicapps.redditpics.activity;

import android.app.Activity;
import android.os.Bundle;

import com.androidquery.AQuery;
import com.basicapps.redditpics.R;

public class FullscreenImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fullscreen_image_activity_layout);

		String imageUrl = getIntent().getStringExtra("image_url");
		//String thumbnailUrl = getIntent().getStringExtra("thumbnail_url");
		
		AQuery aq = new AQuery(this);
		//aq.id(R.id.fullscreenImage_imageView).image(imageUrl, false, true, 500, 0, aq.getCachedImage(thumbnailUrl), AQuery.FADE_IN, AQuery.RATIO_PRESERVE);
		
		aq.id(R.id.fullscreenWebview_webView).webImage(imageUrl, true, true, (int)0xFF000000);
		
	}

}
