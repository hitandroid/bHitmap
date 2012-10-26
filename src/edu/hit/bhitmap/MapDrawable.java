package edu.hit.bhitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/*
 * 该类中封装了一个地图图元的信息，每个MyDrawable类是在地图上占有一个格子，
 * 该类中包含图片引用，图片宽高，图片位置（row，col）
 */

public class MapDrawable{
	
	public static final int TILE_SIZE = 256;	//图块的大小
	Bitmap bmpSelf;//自己图片的引用
	private int width;//图元的宽度
	private int height;//图元的高度
	private int col;//在大地图中所在的列
	private int row;//在大地图中所在的行

	
	public MapDrawable(){}//无参构造函数
	
	//有参构造函数
	public MapDrawable(Bitmap bmpSelf){
		this.bmpSelf = bmpSelf;
		this.width = this.bmpSelf.getWidth();
		this.height = this.bmpSelf.getHeight();
	}
	
/*	方法：绘制自己
	offset为与基础位置的偏移量，介于0～256像素之间。若小于0或大于256则screenRow或screenCol发生变化
	screenCol最大为屏幕宽度/width+1
	screenRow最大为屏幕高度/height+1
*/	
	public void drawSelf(Canvas canvas,int screenRow, int screenCol,int offsetX,int offsetY){
		int relX = screenCol*TILE_SIZE;//屏幕上的相对x坐标
		int relY = screenRow*TILE_SIZE;//屏幕上的相对y坐标
		canvas.drawBitmap(bmpSelf, relX-offsetX, relY-offsetY, null);//根据自己的左上角的xy坐标画出自己
	}
}
