package com.basicapps.redditpics.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.basicapps.redditpics.R;

public class SplashActivity extends Activity {
	
	private static final int SPLASH_SCREEN_DELAY = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.splash_activity_layout);
		
		Timer splashScreenTimer = new Timer();
		splashScreenTimer.schedule( new TimerTask() {
			@Override
			public void run() {
				SplashActivity.this.launchMainApplicaiton();
			}		}, SPLASH_SCREEN_DELAY);
		
	}
	
	private void launchMainApplicaiton() {
		Intent launchIntent = new Intent(SplashActivity.this, ImageListActivity.class);
		startActivity(launchIntent);
		this.finish();
	}
	
	
}
