package edu.hit.bhitmap;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import edu.hit.bhitmap.MapDrawable;

//该类为地图的显示类
public class MapView extends FrameView implements SurfaceHolder.Callback,View.OnTouchListener{

	public MapView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	//一些常量
	public final int SCREEN_WIDTH = 640;
	public final int SCREEN_HEIGHT = 960;
	public static int MAP_COL=9;
	public static final int MAP_ROW=6;
	public static final int TILE_SIZE = 256;

	//参考点的四个变量
	int absRow = 2;//屏幕左上角的图元在大地图中行数
	int absCol = 2;//同上，列数
	float absX = 0;//屏幕参考点（屏幕左上角）在大地图上的x方向偏移，用来实现无级滚屏
	float absY = 0;//屏幕参考点在大地图上的y方向偏移，用来实现无级滚屏

	//触摸点的四个变量
	float touchX; //触摸中心点的x坐标（绝对）
	float touchY; //触摸中心点的y坐标（绝对）
	int touchColX;//计算触摸中心点位于哪个格子
	int touchRowY;//计算触摸中心点位于哪个格子

	//绘制时屏幕上的四个变量
	float screenX;
	float screenY;
	int screenColX;
	int screenRowY;

	//触摸时屏幕上的四个变量
	float touchScreenX;
	float touchScreenY;
	int touchscreenColX;
	int touchscreenRowY;
	
	//触摸时屏幕上的点
	static float x1;
	static float y1;
	static float tempimgX;
	static float tempimgY; 
	
	//显示在屏幕上的
	private String text = "尚未触摸";

	public static MapDrawable[][] mapData;

	//得到地图数据的地址
	String getPathzoom4(int col,int row){
		StringBuffer filenameBuffer = new StringBuffer();
		filenameBuffer.append("/mnt/sdcard/mapdate/zoom4/");
		filenameBuffer.append(col);
		filenameBuffer.append("_");
		filenameBuffer.append(row);
		filenameBuffer.append(".jpg");
		return filenameBuffer.toString();
	}
	
	String getPathzoom3(int col,int row){
		StringBuffer filenameBuffer = new StringBuffer();
		filenameBuffer.append("/mnt/sdcard/mapdate/zoom3/");
		filenameBuffer.append(col);
		filenameBuffer.append("_");
		filenameBuffer.append(row);
		filenameBuffer.append(".jpg");
		return filenameBuffer.toString();
	}


	//自己写的绘制屏幕的方法
	@Override
	public void drawSurfaceView(Canvas canvas, Paint paint) {
		super.drawSurfaceView(canvas, paint);
		canvas.drawColor(255);
		paint.setTextSize(30);
	
		//绘制一个屏幕上的图形
		absCol=(int)(absX/256+1);
		absRow=(int)(absY/256+1);
		float offsetX = absX%256;
		float offsetY = absY%256;
		for (int screenCol=0;screenCol<=3;screenCol++){
			for (int screenRow=0;screenRow<=4;screenRow++){		
				canvas.drawBitmap(BitmapFactory.decodeFile(getPathzoom3(absCol+screenCol, absRow+screenRow)), screenCol*TILE_SIZE-offsetX, screenRow*TILE_SIZE-offsetY, null);
			}
		}	
		canvas.drawText(text + "X:  " + absX + "  Y:  " + absY, 200, 50, paint);
	}

	//触摸的监听器
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// 获取点击的X,y坐标
		float x = event.getX();
		float y = event.getY();

		// --触摸按下事件
		if (event.getAction() == event.ACTION_DOWN) {
			tempimgX = absX;
			tempimgY = absY;
			x1 = x;
			y1 = y;
			text = "触摸按下";
			Log.v("TouchView", "ACTION_DOWN");
		}
		// --触摸移动事件
		if (event.getAction() == event.ACTION_MOVE) {
			absX = tempimgX+x1-x;
			absY = tempimgY+y1-y;
			text = "触摸移动";
			Log.v("TouchView", "ACTION_MOVE");
		}
		// --触摸抬起事件
		if (event.getAction() == event.ACTION_UP) {
			text = "触摸抬起";
			Log.v("TouchView", "ACTION_UP");
		}
		// return super.onTouch(v, event);
		return true;
	}
}


