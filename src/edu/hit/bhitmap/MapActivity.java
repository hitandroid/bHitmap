package edu.hit.bhitmap;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MapActivity extends Activity {
	MapView mapView;
	MapDate mapdate;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*** 设置去标题 ***/
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		/*** 设置全屏 ***/
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
/*		*//*** 设置横屏 ***//*
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);*/
		/*** 设置当前显示的界面 ***/
		setContentView(mapView = new MapView(this));
	}
}