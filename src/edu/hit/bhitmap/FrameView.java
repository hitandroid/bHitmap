package edu.hit.bhitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class FrameView extends SurfaceView implements OnTouchListener,
		Callback, Runnable {

	/** 每sleepTime帧刷新一次屏幕 **/
	private final int sleepTime = 20;
	/** 控制线程的绘制 **/
	private boolean isRun = true;
	public static String tag = "MySurfaceView";
	private Thread currentThread;
	private SurfaceHolder holder;

	public FrameView(Context context) {
		super(context);
		/** 得到SurfaceHolder对象 **/
		holder = this.getHolder();
		/** 添加到callBack中 **/
		holder.addCallback(this);
		/** 设置监听事件 **/
		this.setOnTouchListener(this);
	}

	/**
	 * 开启线程
	 */
	public void startThread() {
		isRun = true;
		currentThread = new Thread(this);
		currentThread.start();
		Log.v(tag, "startThread");
	}

	/**
	 * 暂停线程
	 */
	public void destroyThread() {
		isRun = false;
		Log.v(tag, "destroyThread");
	}

	/**
	 * 绘制画面的方法
	 * 
	 * @param canvas
	 * @param paint
	 */
	public void drawSurfaceView(Canvas canvas, Paint paint) {
		/** 在这里绘制图像 **/
	}

	/**
	 * 当前画面被创建时
	 */
	public void surfaceCreated(SurfaceHolder holder) {
		/** 开启线程 **/
		startThread();
		Log.v(tag, "surfaceCreated");
	}

	/**
	 * 当前画面大小改变时
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.v(tag, "surfaceChanged");
	}

	/**
	 * 当前画面销毁时
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
		/** 暂停线程 **/
		destroyThread();
		Log.v(tag, "surfaceDestroyed");
	}

	/**
	 * 触摸事件
	 */
	public boolean onTouch(View v, MotionEvent event) {
		return true;
	}

	public void run() {
		Canvas c = null;
		Paint paint = new Paint();
		while (isRun) {
			try {
				/** 拿到当前画布，然后锁定 **/
				synchronized (holder) {
					c = holder.lockCanvas();
					drawSurfaceView(c, paint);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				/** 绘制结束后，将画布显示在屏幕上 **/
				if (c != null) {
					holder.unlockCanvasAndPost(c);
				}
			}
			try {
				/** 设置睡眠时间 **/
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}