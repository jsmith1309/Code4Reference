package com.example.jellybeananimationexample;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void scaleupAnimation(View view){
		 // Create a scale-up animation that originates at the button
        // being pressed.
        ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(
                view, 0, 0, view.getWidth(), view.getHeight());
        // Request the activity be started, using the custom animation options.
        startActivity(new Intent(MainActivity.this, ExampleAnimationActivity.class), opts.toBundle());
	}
	
	public void thumbNailScaleAnimation(View view){
	    view.setDrawingCacheEnabled(true);
        view.setPressed(false);
        view.refreshDrawableState();
        Bitmap bitmap = view.getDrawingCache();
       // Canvas canvas = new Canvas(bitmap);
        ActivityOptions opts = ActivityOptions.makeThumbnailScaleUpAnimation(
                view, bitmap, 0, 0);
        // Request the activity be started, using the custom animation options.
        startActivity(new Intent(MainActivity.this, ExampleAnimationActivity.class), opts.toBundle());
        view.setDrawingCacheEnabled(false);
	}
	
	public void zoomAnimation(View view){
		 ActivityOptions opts = ActivityOptions.makeCustomAnimation(MainActivity.this,
                 R.anim.zoom_enter, R.anim.zoom_enter);
         // Request the activity be started, using the custom animation options.
         startActivity(new Intent(MainActivity.this, ExampleAnimationActivity.class), opts.toBundle());
	}
	
	public void fadeAnimation(View view){
		 ActivityOptions opts = ActivityOptions.makeCustomAnimation(MainActivity.this,
                 R.anim.fade, R.anim.hold);
         // Request the activity be started, using the custom animation options.
         startActivity(new Intent(MainActivity.this, ExampleAnimationActivity.class), opts.toBundle());
	}
}