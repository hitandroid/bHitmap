package edu.hit.bhitmap;

import android.view.View;
import android.graphics.BitmapFactory;

//该类中封装地图数据
public class MapDate {
	//常量
	public final int MAP_COL=9;
	public final int MAP_ROW=6;
	
	
	private int col;
	private int row;
	StringBuffer[][] filenameBuffer;//文件名

	public static MapDrawable[][] mapData; //图元矩阵，读取进内存
	

	//地图的初始化。
	void initMapdate(){
/*		for (col=0;col<MAP_COL;col++){
			for (row=0;row<MAP_ROW;row++){
				filenameBuffer[col][row].append("/mnt/sdcard/mapdate/zoom4/");
				filenameBuffer[col][row].append(col);
				filenameBuffer[col][row].append("_");
				filenameBuffer[col][row].append(row);
				filenameBuffer[col][row].append(".jpg");
				mapData[col][row] = new MapDrawable(BitmapFactory.decodeFile(filenameBuffer.toString()));
		
			}
		}	*/
		mapData[1][1] = new MapDrawable(BitmapFactory.decodeFile("/mnt/sdcard/mapdate/zoom4/1_1.jpg"));
	}
}
