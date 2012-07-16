package com.basicapps.redditpics.activity;

import com.basicapps.redditpics.R;

import android.app.Activity;
import android.os.Bundle;

public class ImageListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.image_list_activity_layout);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
